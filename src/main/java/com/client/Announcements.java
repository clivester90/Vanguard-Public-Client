package com.client;


/**
 *
 * @author C.T for koranes
 *
 */

public class Announcements {

    public static int announcementFade = 0;
    public static int announcementMovement = 765 - 2;

    private static final String[] announcements = {
            "Welcome to "+Configuration.CLIENT_TITLE+"!",
            "Owners: Grim & Dbcrazy",
            "Be sure to ::vote every 12 hours!",
            "Keep up with updates & more at ::discord!"
    };

    static int ticks = 0;
    static int maximum = announcements.length;

    public static void displayAnnouncements() {
        announcementMovement--;
        announcementFade++;

        if (announcementMovement < - announcements[ticks].length() - 10) {
            announcementMovement = 765 + 2;
            ticks++;
            if (ticks >= maximum) {
                ticks = 0;
            }
        }

        TextDrawingArea.drawAlphaGradient(0, 0, 765, 25, 0x783F04, 0x783F04, 205 - (int) (50 * Math.sin(announcementFade / 20.0)));
        Client.instance.smallText.method389(true, announcementMovement, 0xffd966, announcements[ticks], 17);
    }





}
