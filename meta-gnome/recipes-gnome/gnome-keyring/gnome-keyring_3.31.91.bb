SUMMARY = "GNOME management of secrets, passwords, keys, and certificates"
HOMEPAGE = "https://wiki.gnome.org/Projects/GnomeKeyring"

LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
                    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c"

inherit gettext gnome

SRC_URI[archive.md5sum] = "8b6c33409fc62f1431647c74c34a9c6b"
SRC_URI[archive.sha256sum] = "a4d90afc4dabe77c6ff8b606588ad782621df8efeb114cbdc619dc4e38a65eba"

DEPENDS = "gcr intltool-native glib-2.0-native libpam"
RDEPENDS_${PN} = "gcr libpam"
FILES_${PN} += "\
    ${libdir}/pkcs11 \
    ${libdir}/security \
    ${datadir}/p11-kit \
    ${datadir}/dbus-1 \
"

EXTRA_OECONF = "--disable-doc --disable-ssh-agent"

