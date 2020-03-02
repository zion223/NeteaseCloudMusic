package com.imooc.lib_audio.mediaplayer.model;

import com.imooc.lib_audio.mediaplayer.db.AudioBeanDao;
import com.imooc.lib_audio.mediaplayer.db.DaoSession;
import com.imooc.lib_audio.mediaplayer.db.FavouriteDao;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * 收藏表
 */
@Entity
public class Favourite {

	@Id(autoincrement = true)
	Long favouriteId;
	@NotNull
	String audioId;
	//一条收藏记录唯一对应一条实体
	@ToOne(joinProperty = "audioId")
	AudioBean audioBean;
	/**
	 * Used to resolve relations
	 */
	@Generated(hash = 2040040024)
	private transient DaoSession daoSession;
	/**
	 * Used for active entity operations.
	 */
	@Generated(hash = 1743949577)
	private transient FavouriteDao myDao;
	@Generated(hash = 249106606)
	private transient String audioBean__resolvedKey;

	@Generated(hash = 1445024019)
	public Favourite(Long favouriteId, @NotNull String audioId) {
		this.favouriteId = favouriteId;
		this.audioId = audioId;
	}

	@Generated(hash = 1933414424)
	public Favourite() {
	}

	public Long getFavouriteId() {
		return this.favouriteId;
	}

	public void setFavouriteId(Long favouriteId) {
		this.favouriteId = favouriteId;
	}

	public String getAudioId() {
		return this.audioId;
	}

	public void setAudioId(String audioId) {
		this.audioId = audioId;
	}

	/**
	 * To-one relationship, resolved on first access.
	 */
	@Generated(hash = 281167394)
	public AudioBean getAudioBean() {
		String __key = this.audioId;
		if (audioBean__resolvedKey == null || audioBean__resolvedKey != __key) {
			final DaoSession daoSession = this.daoSession;
			if (daoSession == null) {
				throw new DaoException("Entity is detached from DAO context");
			}
			AudioBeanDao targetDao = daoSession.getAudioBeanDao();
			AudioBean audioBeanNew = targetDao.load(__key);
			synchronized (this) {
				audioBean = audioBeanNew;
				audioBean__resolvedKey = __key;
			}
		}
		return audioBean;
	}

	/**
	 * called by internal mechanisms, do not call yourself.
	 */
	@Generated(hash = 910180402)
	public void setAudioBean(@NotNull AudioBean audioBean) {
		if (audioBean == null) {
			throw new DaoException(
					"To-one property 'audioId' has not-null constraint; cannot set to-one to null");
		}
		synchronized (this) {
			this.audioBean = audioBean;
			audioId = audioBean.getId();
			audioBean__resolvedKey = audioId;
		}
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 128553479)
	public void delete() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.delete(this);
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 1942392019)
	public void refresh() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.refresh(this);
	}

	/**
	 * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
	 * Entity must attached to an entity context.
	 */
	@Generated(hash = 713229351)
	public void update() {
		if (myDao == null) {
			throw new DaoException("Entity is detached from DAO context");
		}
		myDao.update(this);
	}

	/**
	 * called by internal mechanisms, do not call yourself.
	 */
	@Generated(hash = 1142028328)
	public void __setDaoSession(DaoSession daoSession) {
		this.daoSession = daoSession;
		myDao = daoSession != null ? daoSession.getFavouriteDao() : null;
	}
}
