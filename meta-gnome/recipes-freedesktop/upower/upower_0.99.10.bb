SUMMARY = "Linux power management daemon"
HOMEPAGE = "http://upower.freedesktop.org"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=0de8fbf1d97a140d1d93b9f14dcfbf08"

SRC_URI = "https://gitlab.freedesktop.org/upower/upower/uploads/c438511024b9bc5a904f8775cfc8e4c4/upower-0.99.10.tar.xz"
SRC_URI[md5sum] = "ac6b6bee31110fd8478a8e881c40fba6"
SRC_URI[sha256sum] = "642251b97080ede8be6dbfeaf8f30ff6eadd6eb27aa137bc50f5b9b2295ba29d"


DEPENDS = "libusb1 glib-2.0 intltool-native libgudev"

inherit gettext pkgconfig autotools gobject-introspection

FILES_${PN} += "\
    ${datadir}/dbus-1 \
    ${systemd_system_unitdir} \
"

EXTRA_OECONF = "--enable-man-pages=no --enable-gtk-doc=no"

