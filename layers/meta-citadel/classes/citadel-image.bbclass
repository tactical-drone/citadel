
DEPENDS_append = " mtools-native coreutils-native"

# Block size must be 4096 or dm-verity won't work
EXTRA_IMAGECMD_ext4 = "-i 4096 -b 4096"
IMAGE_FSTYPES = "ext4"
IMAGE_OVERHEAD_FACTOR = "1.2"

inherit image
inherit citadel-deploy

addtask do_deploy after do_image_ext4 before do_image_complete

IMAGE_POSTPROCESS_COMMAND += " generate_shasum_buildhistory ;"

generate_shasum_buildhistory() {
    mkdir -p ${BUILDHISTORY_DIR_IMAGE}
    ( cd ${IMAGE_ROOTFS} && find . -type f -exec sha1sum '{}' \; | sort -k2 > ${BUILDHISTORY_DIR_IMAGE}/image-shasums.txt )
}
