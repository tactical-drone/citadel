DESCRIPTION = "Citadel Realmfs Image Builder"
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

PROVIDES = "citadel-realmfs"

include citadel-image.inc
inherit citadel-deploy

S = "${WORKDIR}/realmfs-builder"

CITADEL_IMAGE_SOURCE_DIR = "${S}/build/realmfs"
CITADEL_IMAGE_SOURCE_NAME = "${CITADEL_REALMFS_EXT4}"
CITADEL_IMAGE_TYPE = "realmfs"
CITADEL_IMAGE_REALMFS_NAME = "base"

SRC_URI = "\
    file://citadel-realmfs-builder.tar.gz \
"

addtask do_deploy after do_compile before do_build
addtask do_root_shell_clean after do_deploy before do_build

do_compile() {
    bbnote "Building image of size ${CITADEL_REALMFS_SIZE_MB} Mb ..."
    oe_runmake ${CITADEL_REALMFS_EXT4} REALMFS_IMAGE=${CITADEL_REALMFS_EXT4} REALMFS_SIZE_MB=${CITADEL_REALMFS_SIZE_MB}
}

do_root_shell_clean() {
    if [ -d ${S} ] ; then
        cd ${S}
        if [ -e ${S}/Makefile ] ; then
            oe_runmake clean
        fi
    fi
}

do_clean_prepend () {
    bb.note("Cleaning root files")
    bb.build.exec_func("do_root_shell_clean", d)
}

