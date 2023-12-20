package com.client.graphics.loaders;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.zip.GZIPInputStream;

import com.client.Configuration;
import com.client.DataUtils;
import com.client.Sprite;
import com.client.Buffer;
import com.client.sign.Signlink;
import com.client.utilities.FileOperations;

public class SpriteLoader4 {

	/**
	 * Loads the sprite data and index files from the overlays location. This can be
	 * edited to use an archive such as config or media to load from the overlays.
	 * 
	 * @param archive
	 */
	public static void loadSprites() {
		try {
			Buffer index = new Buffer(FileOperations.readFile(Signlink.getCacheDirectory() + "media_archives/media_archive4.idx"));
			Buffer data = new Buffer(FileOperations.readFile(Signlink.getCacheDirectory() + "media_archives/media_archive4.dat"));
			DataInputStream indexFile = new DataInputStream(
					new GZIPInputStream(new ByteArrayInputStream(index.payload)));
			DataInputStream dataFile = new DataInputStream(new GZIPInputStream(new ByteArrayInputStream(data.payload)));
			int totalSprites = indexFile.readInt();
			if (cache == null) {
				cache = new SpriteLoader4[totalSprites];
				sprites = new Sprite[totalSprites];
			}
			for (int i = 0; i < totalSprites; i++) {
				int id = indexFile.readInt();
				if (cache[id] == null) {
					cache[id] = new SpriteLoader4();
				}
				cache[id].readValues(indexFile, dataFile);
				createSprite(cache[id]);
			}
			indexFile.close();
			dataFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Reads the information from the index and data files.
	 * 
	 * @param index
	 *            holds the sprite indices
	 * @param data
	 *            holds the sprite data per index
	 * @throws IOException
	 */
	public void readValues(DataInputStream index, DataInputStream data) throws IOException {
		do {
			int opCode = data.readByte();
			if (opCode == 0) {
				break;
			}
			if (opCode == 1) {
				id = data.readShort();
			} else if (opCode == 2) {
				name = data.readUTF();
			} else if (opCode == 3) {
				drawOffsetX = data.readShort();
			} else if (opCode == 4) {
				drawOffsetY = data.readShort();
			} else if (opCode == 5) {
				int indexLength = index.readInt();
				byte[] dataread = new byte[indexLength];
				data.readFully(dataread);
				spriteData = dataread;
			}
		} while (true);
	}

	/**
	 * Creates a sprite out of the spriteData.
	 * 
	 * @param sprite
	 */
	public static void createSprite(SpriteLoader4 sprite) {
		if (Configuration.DUMP_SPRITES) {
			File directory = new File(Signlink.getCacheDirectory() + "Sprites/dump4/");
			if (!directory.exists()) {
				directory.mkdir();
			}
			DataUtils.writeFile(
					new File(directory.getAbsolutePath() + System.getProperty("file.separator") + sprite.id + ".png"),
					sprite.spriteData);
		}
		sprites[sprite.id] = new Sprite(sprite.spriteData);
		sprites[sprite.id].drawOffsetX = sprite.drawOffsetX;
		sprites[sprite.id].drawOffsetY = sprite.drawOffsetY;
	}

	/**
	 * Gets the name of a specified sprite index.
	 * 
	 * @param index
	 * @return
	 */
	public static String getName(int index) {
		return Objects.requireNonNullElse(cache[index].name, "null");
	}

	/**
	 * Gets the drawOffsetX of a specified sprite index.
	 * 
	 * @param index
	 * @return
	 */
	public static int getOffsetX(int index) {
		return cache[index].drawOffsetX;
	}

	/**
	 * Gets the drawOffsetY of a specified sprite index.
	 * 
	 * @param index
	 * @return
	 */
	public static int getOffsetY(int index) {
		return cache[index].drawOffsetY;
	}

	/**
	 * Sets the default values.
	 */
	public SpriteLoader4() {
		name = "name";
		id = -1;
		drawOffsetX = 0;
		drawOffsetY = 0;
		spriteData = null;
	}

	public static SpriteLoader4[] cache;
	public static Sprite[] sprites = null;
	public static int totalSprites;
	public String name;
	public int id;
	public int drawOffsetX;
	public int drawOffsetY;
	public byte[] spriteData;
}