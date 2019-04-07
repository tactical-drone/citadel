LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[archive.md5sum] = "3519b713b08ccfce7ac5b1b8836bbf40"
SRC_URI[archive.sha256sum] = "7668a2208cb40f0f0c3a90dd72c3ea83993dbdfc24f517c6fa95abc04a8e1f19"

DEPENDS = "libxrandr libsm libx11 libxi glib-2.0 wayland-protocols libwacom mesa gtk+3 pango cairo gsettings-desktop-schemas gnome-settings-daemon xcomposite upower gnome-desktop libxkbfile json-glib wayland-native xinerama zenity libinput libcanberra"
RDEPENDS_${PN} = "zenity"

GNOMEBASEBUILDCLASS = "meson"
inherit gettext pkgconfig autotools gobject-introspection gnome

SRC_URI += "file://0001-dont-generate-default-modes-header.patch \
           file://0002-export-get_client_pid.patch \
           file://0001-remove-private-get_client_pid.patch \
           "
FILES_${PN} += "${datadir}/gnome-control-center ${libdir}/mutter-4/*"
FILES_${PN}-dbg += "${datadir}/mutter-4/tests ${datadir}/installed-tests"
FILES_SOLIBSDEV = "${libdir}/mutter-4/lib*.so ${libdir}/lib*.so"

do_compile_prepend() {
    export GIR_EXTRA_LIBS_PATH="${B}/cogl/cogl/.libs:${B}/cogl/cogl-pango/.libs:${B}/cogl/cogl-path/.libs:${B}/clutter/clutter/.libs"
}

#EXTRA_OECONF = "--with-gudev --with-libwacom"
EXTRA_OEMESON = "-Dremote_desktop=false -Dxwayland_path=/usr/bin/Xwayland"

