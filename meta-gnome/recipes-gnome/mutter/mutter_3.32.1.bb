LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

SRC_URI[archive.md5sum] = "6748ec4afdef5e06a9d5639cba3a5cdb"
SRC_URI[archive.sha256sum] = "520082efae0f60f252eed2d0e45e174524f7d7ee1e6bbdbaf5c06f0456a6e4e0"

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

