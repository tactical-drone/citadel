DESCRIPTION = "Citadel Realmfs Builder"
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

PACKAGE_ARCH = "${MACHINE_ARCH}"

include citadel-image.inc

S = "${WORKDIR}/realmfs-builder"

SRC_URI = "\
    file://citadel-realmfs-builder.tar.gz \
"

BBCLASSEXTEND = "native"

#inherit allarch

addtask do_rootclean
addtask do_force_root_clean

do_clean[depends] = "citadel-realmfs-builder:do_rootclean"
do_force_root_clean[depends] = "citadel-realmfs-builder:do_patch"

do_compile() {
    bbnote "Building image of size ${CITADEL_REALMFS_SIZE_MB} Mb"
    oe_runmake ${CITADEL_REALMFS_EXT4} REALMFS_IMAGE=${CITADEL_REALMFS_EXT4} REALMFS_SIZE_MB=${CITADEL_REALMFS_SIZE_MB}
}

do_install() {
    install -d ${D}/realmfs

    install -m 644 ${S}/build/realmfs/${CITADEL_REALMFS_EXT4} ${D}/realmfs
}

do_force_root_clean(){
    do_rootclean
}

do_rootclean(){
    if [ -d ${S} ]
    then
        cd ${S}
	if [ -e Makefile ]; then oe_runmake clean; fi
    fi
}


FILES_${PN} = "/realmfs/${CITADEL_REALMFS_EXT4}"