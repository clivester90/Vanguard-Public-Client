package com.client;

import java.time.LocalDateTime;

public class Configuration {

	/**
	 * Client version is a number that will tell the server whether
	 * the player has the most up-to-date client, otherwise they
	 * will receive an error on login to update their client.
	 */
	public static final int CLIENT_VERSION = 230;

	/**
	 * Cache version is written to the cache folder inside a version file.
	 * This is read on startup to tell if the cache is out of date or not.
	 */
	public static final int CACHE_VERSION = 105; // Change this up one when making cache updates.

	public static final String CACHE_LINK = "http://vanguard317.com/resources/cache.zip";

	public static boolean developerMode = true;
	public static final String CLIENT_TITLE = "Runescape";
	public static final String DISCORD = "https://discord.gg/g6hBw3ws6w";
	public static final String DEDICATED_SERVER_ADDRESS = "127.0.0.1";
	public static final int PORT = 43594;
	public static String CACHE_NAME = "."+ CLIENT_TITLE.toLowerCase();
	public static final String DEV_CACHE_NAME = "local_cache";
	public static final String CACHE_NAME_DEV = CACHE_NAME + "_dev";

	public static final String CUSTOM_ITEM_SPRITES_DIRECTORY = "item_sprites/";
	public static String CUSTOM_MAP_DIRECTORY = "./data/custom_maps/";
	public static String CUSTOM_MODEL_DIRECTORY = "./data/custom_models/";
	public static String CUSTOM_ANIMATION_DIRECTORY = "./data/custom_animations/";
	public static boolean loadExternalCacheArchives = false; // Always true because I can't seem to pack them correctly
	public static boolean packIndexData = false;
	public static boolean dumpMaps = false;
	public static boolean dumpAnimationData = false;
	public static boolean dumpDataLists = false;
	public static boolean newFonts; // TODO text offsets (i.e. spacing between characters) are incorrect, needs automatic fix from kourend

	public static final LocalDateTime LAUNCH_TIME = LocalDateTime.now();
	public static final String ERROR_LOG_DIRECTORY = "error_logs/";
	public static String ERROR_LOG_FILE = ("error_log_"
		+ LAUNCH_TIME.getYear() + "_"
		+ LAUNCH_TIME.getMonth() + "_"
		+ LAUNCH_TIME.getDayOfMonth()
		+ ".txt").toLowerCase();

	/**
	 * Attack option priorities 0 -> Depends on combat level 1 -> Always right-click
	 * 2 -> Left-click where available 3 -> Hidden
	 */
	public static int playerAttackOptionPriority;
	public static int npcAttackOptionPriority = 2;

	public static final boolean DUMP_SPRITES = false;
	public static final boolean PRINT_EMPTY_INTERFACE_SECTIONS = false;

	public static boolean playerNames;

	/**
	 * Seasonal Events
	 */
	public static boolean HALLOWEEN;
	public static boolean CHRISTMAS;
	public static boolean CHRISTMAS_EVENT;
	public static boolean EASTER;

	public static boolean osbuddyGameframe;

	public static int xpPosition;
	public static boolean escapeCloseInterface;
	public static boolean alwaysLeftClickAttack;
	public static boolean hideCombatOverlay;


	public final static int YELLOW = 0xffff01;

	public final static int BLUE = 0x005aff;

	public final static int GOLD = 0xffc600;

	public final static int WHITE = 0xffffff;

	public final static int ORANGE = 0xff981f;

	public final static int BLACK = 0x000000;

	public final static int PALE_ORANGE = 0xc8aa64;

	public final static int RED = 0xfe3200;

	public final static int DARK_BLUE = 0x000080;

	public final static int GREEN = 0x09FF00;

	public final static int PALE_GREEN = 0x46b556;

	public static boolean enablePouch;
	public static boolean statusBars;
	public static boolean menuHovers;

}
