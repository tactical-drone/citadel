SUMMARY = "GNOME terminal emulator"
HOMEPAGE = "https://wiki.gnome.org/Apps/Terminal"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=f27defe1e96c2e1ecd4e0c9be8967949"

DEPENDS = "intltool-native dconf gconf glib-2.0 util-linux gsettings-desktop-schemas glib-2.0-native vte libpcre gtk+3 vala-native libxml2-native desktop-file-utils-native yelp-tools-native"

# python3native is needed to run itstool during build
inherit gettext gnome python3native

SRC_URI[archive.md5sum] = "7f329d387bf047f6a4f742014aa5c813"
SRC_URI[archive.sha256sum] = "240742574974b694ad5c7643684838d28f3dff65be34e478edf92a36cc1495dc"

EXTRA_OECONF = "--disable-search-provider --without-nautilus-extension"

FILES_${PN} += "\
    ${systemd_user_unitdir} \
    ${datadir}/dbus-1/services \
    ${datadir}/glib-2.0/schemas \
    ${datadir}/metainfo \
"

FILES_${PN}-doc += "\
    ${datadir}/help \
"
