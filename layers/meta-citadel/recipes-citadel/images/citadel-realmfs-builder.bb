DESCRIPTION = "Citadel Realmfs Builder"
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

S = "${WORKDIR}"

SRC_URI = "\
    file://citadel-realmfs-builder.tar.gz \
"

inherit allarch gsettings

# Build the binary dconf database which is installed by default into each new realm

do_compile() {
	oe_runmake BASE_DIR=${S} REALMFS_IMAGE=${CITADEL_REALMFS_EXT4}
}

do_install() {
    install -d ${D}realmfs

    install -m 644 ${WORKDIR}/build/${CITADEL_REALMFS_EXT4} ${D}realmfs
}

FILES_${PN} = "/realmfs/${CITADEL_REALMFS_EXT4}"

