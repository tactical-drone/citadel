DESCRIPTION = "Tiny, lightning fast, feature-packed file manager"
SUMMARY = "Small command line file manager"
HOMEPAGE = "https://github.com/jarun/nnn"
SECTION = "base"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=172009f55dfd36284e707e6c251c14c3"

DEPENDS = "ncurses readline"
inherit pkgconfig


SRCREV = "40b98e8c9e78f8e1622968014ed903aeac8a790e"
SRC_URI = "git://github.com/jarun/nnn.git;protocol=https" 
S = "${WORKDIR}/git"

EXTRA_OEMAKE = "'PREFIX=/usr'"

do_install () {
    oe_runmake 'DESTDIR=${D}' install
}

