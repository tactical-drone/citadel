
inherit packagegroup

RDEPENDS_${PN} = "\
    packagegroup-citadel-base \
    citadel-tools \
    citadel-tools-realms \
    packagegroup-desktop \
"
# DEPRICATED   packagegroup-desktop 
#    packagegroup-gnome 
#    packagegroup-sway 
#    packagegroup-theme 
