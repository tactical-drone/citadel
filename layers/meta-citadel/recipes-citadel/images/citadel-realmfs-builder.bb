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

inherit allarch gsettings

# Build the binary dconf database which is installed by default into each new realm

addtask do_root_clean

do_clean[depends] = "citadel-realmfs-builder:do_root_clean"

do_compile() {
    oe_runmake ${CITADEL_REALMFS_EXT4} REALMFS_IMAGE=${CITADEL_REALMFS_EXT4}
}

do_install() {
    install -d ${D}realmfs

    install -m 644 ${S}/build/${CITADEL_REALMFS_EXT4} ${D}realmfs
}

do_root_clean(){
    cd ${S}
    oe_runmake clean
}


FILES_${PN} = "/realmfs/${CITADEL_REALMFS_EXT4}"