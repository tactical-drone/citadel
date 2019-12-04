#
# Packages common to any desktop environment
#

inherit packagegroup

CITADEL_POWERTOP = ""
# append only if citadel-powertop override is set
CITADEL_POWERTOP_append_citadel-powertop= "powertop"

RDEPENDS_${PN} = "\
    ${CITADEL_POWERTOP} \
    accountsservice \
    upower \
    plymouth \
    shared-mime-info \
    pulseaudio-server \
    sound-theme-freedesktop \
    iso-codes \
    libgudev \
    networkmanager \
    polkit \
    network-manager-applet \
    clutter-1.0 \
    libxkbcommon \
    xkeyboard-config \
    libusb1 \
    dbus-glib \
    gtk+3 \
    libnotify \
    ttf-bitstream-vera \
    ttf-dejavu-sans-mono \
    startup-notification \
    gconf \
    gcr \
    dconf \
    libsecret \
    libcroco \
    librsvg \
    librsvg-gtk \
    glib-2.0-utils \
    xdg-dbus-proxy \
"

#    libwacom 
#    ibus 
#    colord 
#    colord-plugins 
#    gdm 

