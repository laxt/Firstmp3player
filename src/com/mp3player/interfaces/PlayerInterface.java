/**
 * @author Laxmana
 */

package com.mp3player.interfaces;

import java.io.File;
public interface PlayerInterface {
	public void open(File file);
	public void pause();
	public void stop();
	public void play();
}
