DEPENDS_append = " citadel-tools-native cryptsetup-native"

CITADEL_IMAGE_CHANNEL ??= "dev"
CITADEL_IMAGE_COMPRESS ??= "true"
CITADEL_IMAGE_TYPE ??= "extra"
CITADEL_IMAGE_REALMFS_NAME ??= "none"
CITADEL_IMAGE_VERSION ??= "1"
CITADEL_IMAGE_ARTIFACT_NAME ??= "${PN}.img"
CITADEL_IMAGE_SOURCE_NAME ??= "${IMAGE_LINK_NAME}.ext4"
CITADEL_IMAGE_SOURCE_DIR ??= "${IMGDEPLOYDIR}"
CITADEL_IMAGE_DEST_DIR ??= "none"
CITADEL_IMAGE_DEST_DIR_TMP ??= "${DEPLOYDIR}"


inherit deploy
do_deploy[vardepsexclude] = "DATETIME"

python() {
    if d.getVar('CITADEL_IMAGE_DEST_DIR') != 'none':
        d.setVar( 'DEPLOY_DIR_IMAGE', '${CITADEL_IMAGE_DEST_DIR}' )
    else:
        d.setVar( 'CITADEL_IMAGE_DEST_DIR', '${DEPLOY_DIR_IMAGE}' )
}

do_deploy() {
    bbnote "Creating tmp image in ${CITADEL_IMAGE_DEST_DIR_TMP}"

    cat > ${CITADEL_IMAGE_DEST_DIR_TMP}/mkimage.conf << EOF
image-type = "${CITADEL_IMAGE_TYPE}"
channel = "${CITADEL_IMAGE_CHANNEL}"
version = ${CITADEL_IMAGE_VERSION}
timestamp = "${DATETIME}"
source = "${CITADEL_IMAGE_SOURCE_DIR}/${CITADEL_IMAGE_SOURCE_NAME}"
compress = ${CITADEL_IMAGE_COMPRESS}
EOF

    ver=$(printf "%03d" ${CITADEL_IMAGE_VERSION})

    if [ "${CITADEL_IMAGE_TYPE}" = "kernel" ]; then
        KERNEL_ID=$(cat ${DEPLOY_DIR_IMAGE}/kernel.id)
        echo "kernel-version = \"${CITADEL_KERNEL_VERSION}\"" >> ${CITADEL_IMAGE_DEST_DIR_TMP}/mkimage.conf
        echo "kernel-id = \"${KERNEL_ID}\"" >> ${CITADEL_IMAGE_DEST_DIR_TMP}/mkimage.conf
        CITADEL_IMAGE_ARTIFACT_NAME="citadel-kernel-${CITADEL_KERNEL_VERSION}-${CITADEL_IMAGE_CHANNEL}-${ver}.img"
    else
        CITADEL_IMAGE_ARTIFACT_NAME="citadel-${CITADEL_IMAGE_TYPE}-${CITADEL_IMAGE_CHANNEL}-${ver}.img"
    fi

    if [ "${CITADEL_IMAGE_REALMFS_NAME}" != "none" ]; then
        echo "realmfs-name =  \"${CITADEL_IMAGE_REALMFS_NAME}\"" >> ${CITADEL_IMAGE_DEST_DIR_TMP}/mkimage.conf
    fi

    citadel-mkimage ${CITADEL_IMAGE_DEST_DIR_TMP}

    if [ -d "${CITADEL_IMAGE_DEST_DIR_TMP}" ]; then
       cd ${CITADEL_IMAGE_DEST_DIR_TMP} && find . -type f -not -name '*.img' -delete
    fi

    bbnote "citadel-mkimage ${CITADEL_IMAGE_ARTIFACT_NAME}, version = ${CITADEL_IMAGE_VERSION}, c = ${CITADEL_IMAGE_CHANNEL}, t = ${CITADEL_IMAGE_TYPE}, rfs = ${CITADEL_IMAGE_REALMFS_NAME}, zip = ${CITADEL_IMAGE_COMPRESS}"
}

