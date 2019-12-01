DESCRIPTION = "Citadel linux kernel"
LICENSE = "GPLv2"
SECTION = "kernel"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"


SRC_URI = "https://cdn.kernel.org/pub/linux/kernel/v5.x/linux-5.2.9.tar.xz\
    file://0117-WireGuard.patch \
    file://defconfig \
"
SRC_URI[md5sum] = "d7162b4421327c756b1d548204fd8fb1"
SRC_URI[sha256sum] = "b6f02a4b306ca5cd314d72615bfc2650166969613135da202630e6c4e1b5d4e6"

LINUX_VERSION ?= "${PV}"
S = "${WORKDIR}/linux-${LINUX_VERSION}"

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"


do_install(){
    install -d ${D}/usr/src/include
    cp -r ${S}/usr/include ${D}/usr/src
}


FILES_${PN} = "/usr/src/include/"

do_compile(){
   oe_runmake headers_install INSTALL_HDR_PATH=${S}/usr
}

