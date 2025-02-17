package net.pms.dlna;

import net.pms.dlna.virtual.VirtualFolder;

public class FolderLimitLevel extends VirtualFolder {
	private final int level;
	private DLNAResource start;

	public FolderLimitLevel(int level) {
		super("Level " + level, null);
		this.level = level;
		this.start = null;
	}

	public int level() {
		return level;
	}

	public void setStart(DLNAResource r) {
		if (r.getParent() == null) {
			start = r.clone();
		} else {
			start = r.getParent().clone();
		}
		resolve();
	}

	@Override
	public void discoverChildren() {
		if (start != null) {
			addChild(start);
		}
	}

	@Override
	public synchronized void resolve() {
		this.setDiscovered(false);
		this.getChildren().clear();
	}
}
