DESCRIPTION = "Citadel Realmfs Builder"
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

include citadel-image.inc

S = "${WORKDIR}/realmfs-builder"

SRC_URI = "\
    file://citadel-realmfs-builder.tar.gz \
"

BBCLASSEXTEND = "native"

do_compile() {
    bbnote "Building image of size ${CITADEL_REALMFS_SIZE_MB} Mb"
    oe_runmake ${CITADEL_REALMFS_EXT4} REALMFS_IMAGE=${CITADEL_REALMFS_EXT4} REALMFS_SIZE_MB=${CITADEL_REALMFS_SIZE_MB}
}

do_install() {
    install -d ${D}${STAGING_DIR_NATIVE}/realmfs
    install -m 644 ${S}/build/realmfs/${CITADEL_REALMFS_EXT4} ${D}${STAGING_DIR_NATIVE}/realmfs
}

do_root_shell_clean() {
    if [ -d ${S} ] 
    then
        cd ${S}
        if [ -e ${S}/Makefile ] 
        then
            oe_runmake clean
        fi
    fi
}

do_clean_prepend () {
    bb.note("Cleaning root files")
    bb.build.exec_func("do_root_shell_clean", d)
}

SYSROOT_DIRS_NATIVE += "${STAGING_DIR_NATIVE}/realmfs"
