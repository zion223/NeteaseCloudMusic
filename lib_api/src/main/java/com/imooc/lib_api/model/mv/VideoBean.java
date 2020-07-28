package com.imooc.lib_api.model.mv;

import com.imooc.lib_api.model.song.SongDetailBean;

import java.util.List;

public class VideoBean {
    /**
     * {
     * "msg": "发现了更多新内容",
     * "code": 200,
     * "hasmore": true,
     * "datas": [
     * {
     * "type": 1,
     * "displayed": false,
     * "alg": "docIbPref_docIbPref-10743106-video&m130",
     * "extAlg": null,
     * "data": {
     * "alg": "docIbPref_docIbPref-10743106-video&m130",
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "threadId": "R_VI_62_3B86B3CD20E0327C637B9BA44D0EC0F4",
     * "coverUrl": "https://p1.music.126.net/T7WY_UoScee-MWCxMT3YrQ==/109951163573186660.jpg",
     * "height": 720,
     * "width": 1280,
     * "title": "IU 超美现场 二十三岁",
     * "description": null,
     * "commentCount": 621,
     * "shareCount": 1236,
     * "resolutions": [
     * {
     * "resolution": 240,
     * "size": 26909221
     * },
     * {
     * "resolution": 480,
     * "size": 38414959
     * },
     * {
     * "resolution": 720,
     * "size": 52146378
     * }
     * ],
     * "creator": {
     * "defaultAvatar": false,
     * "province": 420000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/5Oud8fLpyKOy-cf3TC4D5w==/109951164622914813.jpg",
     * "accountStatus": 0,
     * "gender": 2,
     * "city": 420500,
     * "birthday": 823487291882,
     * "userId": 98012201,
     * "userType": 201,
     * "nickname": "KPOP现场-YouTube精选",
     * "signature": "Kpop爱好者，歌曲至上，爱豆都爱，一个勤劳的搬运工，什么好看好玩就搬啥，最爱kpop现场混剪，会搬运油管大神的混剪和好看的现场",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951164622914820,
     * "backgroundImgId": 109951164497828240,
     * "backgroundUrl": "http://p1.music.126.net/amfQruZ2wmI8OQ7xe7eNdA==/109951164497828241.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "音乐视频达人"
     * },
     * "djStatus": 10,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951164497828241",
     * "avatarImgIdStr": "109951164622914813",
     * "avatarImgId_str": "109951164622914813"
     * },
     * "urlInfo": {
     * "id": "3B86B3CD20E0327C637B9BA44D0EC0F4",
     * "url": "http://vodkgeyttp9.vod.126.net/cloudmusic/9334d117c3472e1e85d6fc60de0caa84.mp4?ts=1586008474&rid=ADE170238E2BB5B419E8C97E6D969580&rl=3&rs=VxFhlYCOrhxnQimtHQbFOPyQKrqCCrbN&sign=3c377070ef5ffd0a5249427bcd1f9adf&ext=ouMSTmLFIIIlnPYK2G1X9ICzLsix6snlIQgdOvuL7xtQpaM73HYFpSiqnn5qwVvT8B45dzJHSNdWBlr3pFcKLl2Q9%2FSd10VVzoyq4IRBsjHurF%2FlXrRLbfhZ3TKKoPu0llX%2BLe2J%2FQB5q7ait%2BaFXsZrE5MFjMcHzUC8%2F5HWpEouFIjMtpQJp7gs4g70MVKaEgGEt9Gh8cW%2FDIbrIvA9Hs5AhJwtXz2Qhl7%2F3ZKVPbdiGIxn9VGL0tfDXi2yjPbL",
     * "size": 52146378,
     * "validityTime": 1200,
     * "needPay": false,
     * "payInfo": null,
     * "r": 720
     * },
     * "videoGroup": [
     * {
     * "id": 24113,
     * "name": "IU",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57107,
     * "name": "韩语现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57108,
     * "name": "流行现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1100,
     * "name": "音乐现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 58100,
     * "name": "现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 5100,
     * "name": "音乐",
     * "alg": "groupTagRank"
     * }
     * ],
     * "previewUrl": null,
     * "previewDurationms": 0,
     * "hasRelatedGameAd": false,
     * "markTypes": null,
     * "relateSong": [],
     * "relatedInfo": null,
     * "videoUserLiveInfo": null,
     * "vid": "3B86B3CD20E0327C637B9BA44D0EC0F4",
     * "durationms": 230063,
     * "playTime": 2556065,
     * "praisedCount": 13631,
     * "praised": false,
     * "subscribed": false
     * }
     * },
     * {
     * "type": 1,
     * "displayed": false,
     * "alg": "userVec8_userVec8&userVec6&m100",
     * "extAlg": null,
     * "data": {
     * "alg": "userVec8_userVec8&userVec6&m100",
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "threadId": "R_VI_62_F8CEB87B4F23F80D0099A4333B508CFA",
     * "coverUrl": "https://p1.music.126.net/DJvMrsze6NM_RHv0gTYJNQ==/109951163572769937.jpg",
     * "height": 720,
     * "width": 1280,
     * "title": "Blackpink超赞改编Wonder girls《So hot》，果然满满YG风！",
     * "description": "Blackpink超赞改编Wonder girls《So hot》，果然满满YG风！",
     * "commentCount": 1532,
     * "shareCount": 2322,
     * "resolutions": [
     * {
     * "resolution": 240,
     * "size": 19339647
     * },
     * {
     * "resolution": 480,
     * "size": 27528660
     * },
     * {
     * "resolution": 720,
     * "size": 44006064
     * }
     * ],
     * "creator": {
     * "defaultAvatar": false,
     * "province": 500000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/amgABwDJczOJfGnnQakddA==/109951162989596075.jpg",
     * "accountStatus": 0,
     * "gender": 1,
     * "city": 500101,
     * "birthday": 788889600000,
     * "userId": 351909057,
     * "userType": 0,
     * "nickname": "黑塔那个利亚",
     * "signature": "爱看剧，爱追剧～",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951162989596080,
     * "backgroundImgId": 3394192433511977,
     * "backgroundUrl": "http://p1.music.126.net/DVhkqIZCdXkiWPWWHBo2WQ==/3394192433511977.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": null,
     * "djStatus": 0,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "3394192433511977",
     * "avatarImgIdStr": "109951162989596075",
     * "avatarImgId_str": "109951162989596075"
     * },
     * "urlInfo": {
     * "id": "F8CEB87B4F23F80D0099A4333B508CFA",
     * "url": "http://vodkgeyttp9.vod.126.net/vodkgeyttp8/7wUiWUpL_99954622_shd.mp4?ts=1586008474&rid=ADE170238E2BB5B419E8C97E6D969580&rl=3&rs=iVnrbsszedhvOmvjTAmEgGBMXFzObstA&sign=a893413950bc06bc52af47b972ca9462&ext=ouMSTmLFIIIlnPYK2G1X9ICzLsix6snlIQgdOvuL7xtQpaM73HYFpSiqnn5qwVvT8B45dzJHSNdWBlr3pFcKLl2Q9%2FSd10VVzoyq4IRBsjHurF%2FlXrRLbfhZ3TKKoPu0llX%2BLe2J%2FQB5q7ait%2BaFXsZrE5MFjMcHzUC8%2F5HWpEouFIjMtpQJp7gs4g70MVKaEgGEt9Gh8cW%2FDIbrIvA9Hs5AhJwtXz2Qhl7%2F3ZKVPbdiGIxn9VGL0tfDXi2yjPbL",
     * "size": 44006064,
     * "validityTime": 1200,
     * "needPay": false,
     * "payInfo": null,
     * "r": 720
     * },
     * "videoGroup": [
     * {
     * "id": -8001,
     * "name": "#热搜榜#",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 12100,
     * "name": "流行",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 15235,
     * "name": "甜蜜",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 13139,
     * "name": "韩语",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1100,
     * "name": "音乐现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 58100,
     * "name": "现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 5100,
     * "name": "音乐",
     * "alg": "groupTagRank"
     * }
     * ],
     * "previewUrl": null,
     * "previewDurationms": 0,
     * "hasRelatedGameAd": false,
     * "markTypes": null,
     * "relateSong": [
     * {
     * "name": "So Hot",
     * "id": 5411030,
     * "pst": 0,
     * "t": 0,
     * "ar": [
     * {
     * "id": 128048,
     * "name": "Wonder Girls",
     * "tns": [],
     * "alias": []
     * }
     * ],
     * "alia": [],
     * "pop": 95,
     * "st": 0,
     * "rt": "600902000008681622",
     * "fee": 8,
     * "v": 28,
     * "crbt": null,
     * "cf": "",
     * "al": {
     * "id": 531677,
     * "name": "So Hot",
     * "picUrl": "http://p1.music.126.net/sGoFlvmnfV9acrWez-0GIQ==/583840674353185.jpg",
     * "tns": [],
     * "pic": 583840674353185
     * },
     * "dt": 182960,
     * "h": {
     * "br": 320000,
     * "fid": 0,
     * "size": 7320598,
     * "vd": -16100
     * },
     * "m": {
     * "br": 192000,
     * "fid": 0,
     * "size": 4392376,
     * "vd": -13800
     * },
     * "l": {
     * "br": 128000,
     * "fid": 0,
     * "size": 2928265,
     * "vd": -12300
     * },
     * "a": null,
     * "cd": "1",
     * "no": 1,
     * "rtUrl": null,
     * "ftype": 0,
     * "rtUrls": [],
     * "djId": 0,
     * "copyright": 1,
     * "s_id": 0,
     * "rtype": 0,
     * "rurl": null,
     * "mst": 9,
     * "cp": 372011,
     * "mv": 5298273,
     * "publishTime": 1212422400000,
     * "privilege": {
     * "id": 5411030,
     * "fee": 8,
     * "payed": 0,
     * "st": 0,
     * "pl": 128000,
     * "dl": 0,
     * "sp": 7,
     * "cp": 1,
     * "subp": 1,
     * "cs": false,
     * "maxbr": 999000,
     * "fl": 128000,
     * "toast": false,
     * "flag": 0,
     * "preSell": false
     * }
     * },
     * {
     * "name": "WHISTLE (Japanese Ver.)",
     * "id": 502228184,
     * "pst": 0,
     * "t": 0,
     * "ar": [
     * {
     * "id": 12068017,
     * "name": "BLACKPINK",
     * "tns": [],
     * "alias": []
     * }
     * ],
     * "alia": [],
     * "pop": 100,
     * "st": 0,
     * "rt": null,
     * "fee": 1,
     * "v": 15,
     * "crbt": null,
     * "cf": "",
     * "al": {
     * "id": 36031601,
     * "name": "BLACKPINK",
     * "picUrl": "http://p1.music.126.net/3BPc7x_UVZWpHHjg9t4YYg==/109951163014329187.jpg",
     * "tns": [],
     * "pic_str": "109951163014329187",
     * "pic": 109951163014329180
     * },
     * "dt": 212600,
     * "h": {
     * "br": 320000,
     * "fid": 0,
     * "size": 8506558,
     * "vd": -15400
     * },
     * "m": {
     * "br": 192000,
     * "fid": 0,
     * "size": 5103952,
     * "vd": -12800
     * },
     * "l": {
     * "br": 128000,
     * "fid": 0,
     * "size": 3402649,
     * "vd": -11700
     * },
     * "a": null,
     * "cd": "1",
     * "no": 2,
     * "rtUrl": null,
     * "ftype": 0,
     * "rtUrls": [],
     * "djId": 0,
     * "copyright": 1,
     * "s_id": 0,
     * "rtype": 0,
     * "rurl": null,
     * "mst": 9,
     * "cp": 457010,
     * "mv": 0,
     * "publishTime": 1504022400007,
     * "privilege": {
     * "id": 502228184,
     * "fee": 1,
     * "payed": 0,
     * "st": 0,
     * "pl": 0,
     * "dl": 0,
     * "sp": 0,
     * "cp": 0,
     * "subp": 0,
     * "cs": false,
     * "maxbr": 999000,
     * "fl": 0,
     * "toast": false,
     * "flag": 1093,
     * "preSell": false
     * }
     * }
     * ],
     * "relatedInfo": null,
     * "videoUserLiveInfo": null,
     * "vid": "F8CEB87B4F23F80D0099A4333B508CFA",
     * "durationms": 163850,
     * "playTime": 4128870,
     * "praisedCount": 24169,
     * "praised": false,
     * "subscribed": false
     * }
     * },
     * {
     * "type": 1,
     * "displayed": false,
     * "alg": "newArtSong_newArtSong-411315797-song&m97",
     * "extAlg": null,
     * "data": {
     * "alg": "newArtSong_newArtSong-411315797-song&m97",
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "threadId": "R_VI_62_CC2F7C39DFE26F244418EE224F8F7170",
     * "coverUrl": "https://p1.music.126.net/OEeJoe_x_OLYK3LwFBM4fA==/109951163572756063.jpg",
     * "height": 720,
     * "width": 1280,
     * "title": "防弹少年团MAMA演出现场——FIRE！全球弹真的越来越火了！",
     * "description": "防弹少年团MAMA演出现场——FIRE！全球弹真的越来越火了！",
     * "commentCount": 1383,
     * "shareCount": 2028,
     * "resolutions": [
     * {
     * "resolution": 240,
     * "size": 41204587
     * },
     * {
     * "resolution": 480,
     * "size": 58937191
     * },
     * {
     * "resolution": 720,
     * "size": 94289226
     * }
     * ],
     * "creator": {
     * "defaultAvatar": false,
     * "province": 1000000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/UxigoZDzvUvAxwkZnerrqw==/18829136627765330.jpg",
     * "accountStatus": 0,
     * "gender": 0,
     * "city": 1002900,
     * "birthday": 699292800000,
     * "userId": 366961325,
     * "userType": 201,
     * "nickname": "YouTube韩娱精选",
     * "signature": "加：lanyinlin666",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 18829136627765330,
     * "backgroundImgId": 109951163058270430,
     * "backgroundUrl": "http://p1.music.126.net/MQJCvtIORLzIvjmszd-t0g==/109951163058270430.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "音乐视频达人"
     * },
     * "djStatus": 0,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951163058270430",
     * "avatarImgIdStr": "18829136627765330",
     * "avatarImgId_str": "18829136627765330"
     * },
     * "urlInfo": {
     * "id": "CC2F7C39DFE26F244418EE224F8F7170",
     * "url": "http://vodkgeyttp9.vod.126.net/vodkgeyttp8/dZsgqlp5_78997030_shd.mp4?ts=1586008474&rid=ADE170238E2BB5B419E8C97E6D969580&rl=3&rs=GjQuPpBMtyQRTyKEQkgSaIOCRFXPpizc&sign=43a89c816ba274e7ee9e28990aa27e9e&ext=ouMSTmLFIIIlnPYK2G1X9ICzLsix6snlIQgdOvuL7xtQpaM73HYFpSiqnn5qwVvT8B45dzJHSNdWBlr3pFcKLl2Q9%2FSd10VVzoyq4IRBsjHurF%2FlXrRLbfhZ3TKKoPu0llX%2BLe2J%2FQB5q7ait%2BaFXsZrE5MFjMcHzUC8%2F5HWpEouFIjMtpQJp7gs4g70MVKaEgGEt9Gh8cW%2FDIbrIvA9Hs5AhJwtXz2Qhl7%2F3ZKVPbdiGIxn9VGL0tfDXi2yjPbL",
     * "size": 94289226,
     * "validityTime": 1200,
     * "needPay": false,
     * "payInfo": null,
     * "r": 720
     * },
     * "videoGroup": [
     * {
     * "id": -14360,
     * "name": "#BTS (防弹少年团)#",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 10113,
     * "name": "防弹少年团",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57107,
     * "name": "韩语现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57108,
     * "name": "流行现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1100,
     * "name": "音乐现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 58100,
     * "name": "现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 5100,
     * "name": "音乐",
     * "alg": "groupTagRank"
     * }
     * ],
     * "previewUrl": null,
     * "previewDurationms": 0,
     * "hasRelatedGameAd": false,
     * "markTypes": null,
     * "relateSong": [
     * {
     * "name": "Burning Up (FIRE)",
     * "id": 411315797,
     * "pst": 0,
     * "t": 0,
     * "ar": [
     * {
     * "id": 783124,
     * "name": "BTS (防弹少年团)",
     * "tns": [],
     * "alias": []
     * }
     * ],
     * "alia": [],
     * "pop": 100,
     * "st": 0,
     * "rt": null,
     * "fee": 1,
     * "v": 128,
     * "crbt": null,
     * "cf": "",
     * "al": {
     * "id": 34686298,
     * "name": "花样年华 Young Forever",
     * "picUrl": "http://p1.music.126.net/-wiSzVgEsUAmIJ2hskQfpw==/109951163276499358.jpg",
     * "tns": [],
     * "pic_str": "109951163276499358",
     * "pic": 109951163276499360
     * },
     * "dt": 203351,
     * "h": {
     * "br": 320000,
     * "fid": 0,
     * "size": 8136664,
     * "vd": -41700
     * },
     * "m": {
     * "br": 192000,
     * "fid": 0,
     * "size": 4882016,
     * "vd": -39500
     * },
     * "l": {
     * "br": 128000,
     * "fid": 0,
     * "size": 3254692,
     * "vd": -38300
     * },
     * "a": null,
     * "cd": "1",
     * "no": 10,
     * "rtUrl": null,
     * "ftype": 0,
     * "rtUrls": [],
     * "djId": 0,
     * "copyright": 2,
     * "s_id": 0,
     * "rtype": 0,
     * "rurl": null,
     * "mst": 9,
     * "cp": 723010,
     * "mv": 5341023,
     * "publishTime": 1462118400007,
     * "privilege": {
     * "id": 411315797,
     * "fee": 1,
     * "payed": 0,
     * "st": 0,
     * "pl": 0,
     * "dl": 0,
     * "sp": 0,
     * "cp": 0,
     * "subp": 0,
     * "cs": false,
     * "maxbr": 999000,
     * "fl": 0,
     * "toast": false,
     * "flag": 1348,
     * "preSell": false
     * }
     * }
     * ],
     * "relatedInfo": null,
     * "videoUserLiveInfo": null,
     * "vid": "CC2F7C39DFE26F244418EE224F8F7170",
     * "durationms": 341798,
     * "playTime": 1725267,
     * "praisedCount": 16378,
     * "praised": false,
     * "subscribed": false
     * }
     * },
     * {
     * "type": 4,
     * "displayed": false,
     * "alg": null,
     * "extAlg": null,
     * "data": {
     * "alg": null,
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "title": "带你潇洒带你嗨",
     * "rcmdUsers": [
     * {
     * "slogan": " 嘘！全球音乐驾到",
     * "profile": {
     * "defaultAvatar": false,
     * "province": 1000000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/VPGeeVnQ0jLp4hK9kj0EPg==/18897306347016806.jpg",
     * "accountStatus": 0,
     * "gender": 0,
     * "city": 1002400,
     * "birthday": -2209017600000,
     * "userId": 449979212,
     * "userType": 201,
     * "nickname": "全球潮音乐",
     * "signature": "有时候音乐是陪我熬过那些夜晚的唯一朋友。",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 18897306347016810,
     * "backgroundImgId": 18987466300481468,
     * "backgroundUrl": "http://p1.music.126.net/qx6U5-1LCeMT9t7RLV7r1A==/18987466300481468.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "音乐视频达人",
     * "2": "华语音乐|欧美音乐资讯达人"
     * },
     * "djStatus": 0,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "18987466300481468",
     * "avatarImgIdStr": "18897306347016806",
     * "avatarImgId_str": "18897306347016806",
     * "followeds": 445260
     * }
     * },
     * {
     * "slogan": "舞台直拍，你的Idol在哪里",
     * "profile": {
     * "defaultAvatar": false,
     * "province": 1000000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/guVIAao6A_-CH9MkYxCJ6w==/109951164868833648.jpg",
     * "accountStatus": 0,
     * "gender": 1,
     * "city": 1004400,
     * "birthday": 840556800000,
     * "userId": 34616088,
     * "userType": 201,
     * "nickname": "LA角斗士",
     * "signature": "Stay Alive",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951164868833650,
     * "backgroundImgId": 109951163484001120,
     * "backgroundUrl": "http://p1.music.126.net/2HvSVB6h_ydXsfyu1K2oig==/109951163484001128.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "音乐视频达人"
     * },
     * "djStatus": 10,
     * "vipType": 11,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951163484001128",
     * "avatarImgIdStr": "109951164868833648",
     * "avatarImgId_str": "109951164868833648",
     * "followeds": 30924
     * }
     * },
     * {
     * "slogan": "惊艳的摇滚爵士演奏现场",
     * "profile": {
     * "defaultAvatar": false,
     * "province": 110000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/34DzOtbJhyYj7BXj-dxeYg==/19226060323323558.jpg",
     * "accountStatus": 0,
     * "gender": 1,
     * "city": 110101,
     * "birthday": -2209017600000,
     * "userId": 439675863,
     * "userType": 201,
     * "nickname": "Steven_爱音乐",
     * "signature": "流行、摇滚、爵士、蓝调精选视频欣赏、乐器学习、世界大师现场。",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 19226060323323560,
     * "backgroundImgId": 109951162868128400,
     * "backgroundUrl": "http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "音乐视频达人"
     * },
     * "djStatus": 0,
     * "vipType": 11,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951162868128395",
     * "avatarImgIdStr": "19226060323323558",
     * "avatarImgId_str": "19226060323323558",
     * "followeds": 105505
     * }
     * },
     * {
     * "slogan": "爆好听的全球现场集锦",
     * "profile": {
     * "defaultAvatar": false,
     * "province": 1000000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/duYWRme_A2G0nEWwGvGmdw==/109951164221922438.jpg",
     * "accountStatus": 0,
     * "gender": 0,
     * "city": 1001300,
     * "birthday": 628617600000,
     * "userId": 415197557,
     * "userType": 201,
     * "nickname": "全球音乐吧",
     * "signature": "别错过年轻的疯狂，时光很匆忙！\n（合作✔✘--guoxiaoyv1203）",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951164221922430,
     * "backgroundImgId": 109951164223300530,
     * "backgroundUrl": "http://p1.music.126.net/Qhoc0wtgOqP6jjRjBZc71Q==/109951164223300532.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "音乐视频达人",
     * "2": "欧美音乐资讯达人"
     * },
     * "djStatus": 10,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951164223300532",
     * "avatarImgIdStr": "109951164221922438",
     * "avatarImgId_str": "109951164221922438",
     * "followeds": 429462
     * }
     * },
     * {
     * "slogan": "偶像零距离",
     * "profile": {
     * "defaultAvatar": false,
     * "province": 110000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/TkpvMmZxXCsumKdxz3x41w==/109951164432545192.jpg",
     * "accountStatus": 0,
     * "gender": 0,
     * "city": 110101,
     * "birthday": -2209017600000,
     * "userId": 1465744613,
     * "userType": 201,
     * "nickname": "音乐一剪没",
     * "signature": "",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951164432545180,
     * "backgroundImgId": 109951162868128400,
     * "backgroundUrl": "http://p1.music.126.net/2zSNIqTcpHL2jIvU6hG0EA==/109951162868128395.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "泛生活视频达人"
     * },
     * "djStatus": 0,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951162868128395",
     * "avatarImgIdStr": "109951164432545192",
     * "avatarImgId_str": "109951164432545192",
     * "followeds": 1766
     * }
     * }
     * ]
     * }
     * },
     * {
     * "type": 1,
     * "displayed": false,
     * "alg": "qryVec_qryVec-平凡之路-tag&m207",
     * "extAlg": null,
     * "data": {
     * "alg": "qryVec_qryVec-平凡之路-tag&m207",
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "threadId": "R_VI_62_3D9FF586492E1B4FBA75522428CF3976",
     * "coverUrl": "https://p1.music.126.net/bwQwScYDiW2jdjAErolCPQ==/109951163572233188.jpg",
     * "height": 540,
     * "width": 960,
     * "title": "打扰一下乐团《平凡之路》演唱会版。",
     * "description": null,
     * "commentCount": 4171,
     * "shareCount": 43688,
     * "resolutions": [
     * {
     * "resolution": 240,
     * "size": 27369055
     * },
     * {
     * "resolution": 480,
     * "size": 38421473
     * }
     * ],
     * "creator": {
     * "defaultAvatar": false,
     * "province": 330000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/S_1teRQAVTw493vNeDv-lQ==/109951163090553663.jpg",
     * "accountStatus": 0,
     * "gender": 1,
     * "city": 330100,
     * "birthday": 697996800000,
     * "userId": 375820458,
     * "userType": 201,
     * "nickname": "我们爱现场",
     * "signature": "",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951163090553660,
     * "backgroundImgId": 109951162886470270,
     * "backgroundUrl": "http://p1.music.126.net/itXX1Qy3Wau9vbSZZWiORg==/109951162886470275.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "音乐视频达人",
     * "2": "音乐图文达人"
     * },
     * "djStatus": 0,
     * "vipType": 11,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951162886470275",
     * "avatarImgIdStr": "109951163090553663",
     * "avatarImgId_str": "109951163090553663"
     * },
     * "urlInfo": {
     * "id": "3D9FF586492E1B4FBA75522428CF3976",
     * "url": "http://vodkgeyttp9.vod.126.net/vodkgeyttp8/cDSDOOU4_3958190_hd.mp4?ts=1586008474&rid=ADE170238E2BB5B419E8C97E6D969580&rl=3&rs=nNqZGXBRFEmtFNMtebJqgypKiWfezaWF&sign=6f2921f699162e68950a313feb88412b&ext=ouMSTmLFIIIlnPYK2G1X9ICzLsix6snlIQgdOvuL7xtQpaM73HYFpSiqnn5qwVvT8B45dzJHSNdWBlr3pFcKLl2Q9%2FSd10VVzoyq4IRBsjHurF%2FlXrRLbfhZ3TKKoPu0llX%2BLe2J%2FQB5q7ait%2BaFXsZrE5MFjMcHzUC8%2F5HWpEouFIjMtpQJp7gs4g70MVKaEgGEt9Gh8cW%2FDIbrIvA9Hs5AhJwtXz2Qhl7%2F3ZKVPbdiGIxn9VGL0tfDXi2yjPbL",
     * "size": 38421473,
     * "validityTime": 1200,
     * "needPay": false,
     * "payInfo": null,
     * "r": 480
     * },
     * "videoGroup": [
     * {
     * "id": 9102,
     * "name": "演唱会",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 25137,
     * "name": "音乐资讯",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1100,
     * "name": "音乐现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 58100,
     * "name": "现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 5100,
     * "name": "音乐",
     * "alg": "groupTagRank"
     * }
     * ],
     * "previewUrl": null,
     * "previewDurationms": 0,
     * "hasRelatedGameAd": false,
     * "markTypes": [
     * 109
     * ],
     * "relateSong": [],
     * "relatedInfo": null,
     * "videoUserLiveInfo": null,
     * "vid": "3D9FF586492E1B4FBA75522428CF3976",
     * "durationms": 292000,
     * "playTime": 7690452,
     * "praisedCount": 78597,
     * "praised": false,
     * "subscribed": false
     * }
     * },
     * {
     * "type": 1,
     * "displayed": false,
     * "alg": "userVec8_userVec8&userVec6&m154",
     * "extAlg": null,
     * "data": {
     * "alg": "userVec8_userVec8&userVec6&m154",
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "threadId": "R_VI_62_5DED86A313C2AB7EE204E5631261BC9A",
     * "coverUrl": "https://p1.music.126.net/24wqOhZBw2raySblfd2ceA==/109951163794664969.jpg",
     * "height": 720,
     * "width": 1280,
     * "title": "blackpink超强翻跳舞蹈碧昂斯partition，真是人美条顺！",
     * "description": null,
     * "commentCount": 575,
     * "shareCount": 1690,
     * "resolutions": [
     * {
     * "resolution": 240,
     * "size": 19615994
     * },
     * {
     * "resolution": 480,
     * "size": 33773143
     * },
     * {
     * "resolution": 720,
     * "size": 52208962
     * }
     * ],
     * "creator": {
     * "defaultAvatar": false,
     * "province": 350000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/nTjB8dpAXjeIhAtNZMNxtw==/109951163794281640.jpg",
     * "accountStatus": 0,
     * "gender": 2,
     * "city": 350100,
     * "birthday": -2209017600000,
     * "userId": 1729388746,
     * "userType": 0,
     * "nickname": "小李爱音乐啊啊",
     * "signature": "",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951163794281630,
     * "backgroundImgId": 109951162868126480,
     * "backgroundUrl": "http://p1.music.126.net/_f8R60U9mZ42sSNvdPn2sQ==/109951162868126486.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": null,
     * "djStatus": 0,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951162868126486",
     * "avatarImgIdStr": "109951163794281640",
     * "avatarImgId_str": "109951163794281640"
     * },
     * "urlInfo": {
     * "id": "5DED86A313C2AB7EE204E5631261BC9A",
     * "url": "http://vodkgeyttp9.vod.126.net/vodkgeyttp8/jFHJCKD3_2253412564_shd.mp4?ts=1586008474&rid=ADE170238E2BB5B419E8C97E6D969580&rl=3&rs=GrpmKLQgXDPnATPmrFyTGrhFvEpfufCH&sign=cf12bfc2de51ef6a71f6dddcb9ab8226&ext=ouMSTmLFIIIlnPYK2G1X9ICzLsix6snlIQgdOvuL7xtQpaM73HYFpSiqnn5qwVvT8B45dzJHSNdWBlr3pFcKLl2Q9%2FSd10VVzoyq4IRBsjHurF%2FlXrRLbfhZ3TKKoPu0llX%2BLe2J%2FQB5q7ait%2BaFXsZrE5MFjMcHzUC8%2F5HWpEouFIjMtpQJp7gs4g70MVKaEgGEt9Gh8cW%2FDIbrIvA9Hs5AhJwtXz2Qhl7%2F3ZKVPbdiGIxn9VGL0tfDXi2yjPbL",
     * "size": 52208962,
     * "validityTime": 1200,
     * "needPay": false,
     * "payInfo": null,
     * "r": 720
     * },
     * "videoGroup": [
     * {
     * "id": -8005,
     * "name": "#收藏榜#",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 92105,
     * "name": "BLACKPINK",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 9102,
     * "name": "演唱会",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57107,
     * "name": "韩语现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57108,
     * "name": "流行现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1101,
     * "name": "舞蹈",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1100,
     * "name": "音乐现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 58100,
     * "name": "现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 5100,
     * "name": "音乐",
     * "alg": "groupTagRank"
     * }
     * ],
     * "previewUrl": null,
     * "previewDurationms": 0,
     * "hasRelatedGameAd": false,
     * "markTypes": null,
     * "relateSong": [],
     * "relatedInfo": null,
     * "videoUserLiveInfo": null,
     * "vid": "5DED86A313C2AB7EE204E5631261BC9A",
     * "durationms": 120512,
     * "playTime": 2664672,
     * "praisedCount": 15371,
     * "praised": false,
     * "subscribed": false
     * }
     * },
     * {
     * "type": 1,
     * "displayed": false,
     * "alg": "userVec6_m147",
     * "extAlg": null,
     * "data": {
     * "alg": "userVec6_m147",
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "threadId": "R_VI_62_350094536B27EA1A1F18372E7282E5BF",
     * "coverUrl": "https://p1.music.126.net/5gX9FODjB4tY9kEgPI84yg==/109951163925518527.jpg",
     * "height": 360,
     * "width": 640,
     * "title": "BLACKPINK纽约时代广场表演《Ddu du Ddu du》，人气爆棚！",
     * "description": "BLACKPINK纽约时代广场表演《Ddu du Ddu du》，人气爆棚！",
     * "commentCount": 906,
     * "shareCount": 1280,
     * "resolutions": [
     * {
     * "resolution": 240,
     * "size": 68342955
     * }
     * ],
     * "creator": {
     * "defaultAvatar": false,
     * "province": 320000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/sBjevuBo0XzMEaPqUz_PYw==/109951162973235599.jpg",
     * "accountStatus": 0,
     * "gender": 2,
     * "city": 320500,
     * "birthday": -2209017600000,
     * "userId": 268137613,
     * "userType": 201,
     * "nickname": "舞蹈侦探",
     * "signature": "QQ708865923",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951162973235600,
     * "backgroundImgId": 109951164500357380,
     * "backgroundUrl": "http://p1.music.126.net/3aTBU-zkvsGS1bSMWf_p7w==/109951164500357368.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "舞蹈视频达人"
     * },
     * "djStatus": 0,
     * "vipType": 11,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951164500357368",
     * "avatarImgIdStr": "109951162973235599",
     * "avatarImgId_str": "109951162973235599"
     * },
     * "urlInfo": {
     * "id": "350094536B27EA1A1F18372E7282E5BF",
     * "url": "http://vodkgeyttp9.vod.126.net/vodkgeyttp8/sjh8FPsx_2375537457_sd.mp4?ts=1586008474&rid=ADE170238E2BB5B419E8C97E6D969580&rl=3&rs=weLCUQKqmxRTopkTlXhEMZnIIqEnCfKG&sign=d5941dc3a9c904c4802b4198e82254c8&ext=ouMSTmLFIIIlnPYK2G1X9ICzLsix6snlIQgdOvuL7xtQpaM73HYFpSiqnn5qwVvT8B45dzJHSNdWBlr3pFcKLl2Q9%2FSd10VVzoyq4IRBsjHurF%2FlXrRLbfhZ3TKKoPu0llX%2BLe2J%2FQB5q7ait%2BaFXsZrE5MFjMcHzUC8%2F5HWpEouFIjMtpQJp7gs4g70MVKaEgGEt9Gh8cW%2FDIbrIvA9Hs5AhJwtXz2Qhl7%2F3ZKVPbdiGIxn9VGL0tfDXi2yjPbL",
     * "size": 68342955,
     * "validityTime": 1200,
     * "needPay": false,
     * "payInfo": null,
     * "r": 240
     * },
     * "videoGroup": [
     * {
     * "id": -8003,
     * "name": "#点赞榜#",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 59107,
     * "name": "最新现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 92105,
     * "name": "BLACKPINK",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57107,
     * "name": "韩语现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57108,
     * "name": "流行现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1101,
     * "name": "舞蹈",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1100,
     * "name": "音乐现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 58100,
     * "name": "现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 5100,
     * "name": "音乐",
     * "alg": "groupTagRank"
     * }
     * ],
     * "previewUrl": null,
     * "previewDurationms": 0,
     * "hasRelatedGameAd": false,
     * "markTypes": null,
     * "relateSong": [
     * {
     * "name": "DDU-DU DDU-DU",
     * "id": 1325896374,
     * "pst": 0,
     * "t": 0,
     * "ar": [
     * {
     * "id": 12068017,
     * "name": "BLACKPINK",
     * "tns": [],
     * "alias": []
     * }
     * ],
     * "alia": [],
     * "pop": 100,
     * "st": 0,
     * "rt": null,
     * "fee": 1,
     * "v": 10,
     * "crbt": null,
     * "cf": "",
     * "al": {
     * "id": 74266151,
     * "name": "BLACKPINK IN YOUR AREA",
     * "picUrl": "http://p1.music.126.net/yKysEblB7-HOVrUCjvRhqw==/109951163678530141.jpg",
     * "tns": [],
     * "pic_str": "109951163678530141",
     * "pic": 109951163678530140
     * },
     * "dt": 209493,
     * "h": {
     * "br": 320000,
     * "fid": 0,
     * "size": 8382215,
     * "vd": -30500
     * },
     * "m": {
     * "br": 192000,
     * "fid": 0,
     * "size": 5029346,
     * "vd": -28000
     * },
     * "l": {
     * "br": 128000,
     * "fid": 0,
     * "size": 3352912,
     * "vd": -26800
     * },
     * "a": null,
     * "cd": "1",
     * "no": 6,
     * "rtUrl": null,
     * "ftype": 0,
     * "rtUrls": [],
     * "djId": 0,
     * "copyright": 0,
     * "s_id": 0,
     * "rtype": 0,
     * "rurl": null,
     * "mst": 9,
     * "cp": 457010,
     * "mv": 0,
     * "publishTime": 1542902400000,
     * "privilege": {
     * "id": 1325896374,
     * "fee": 1,
     * "payed": 0,
     * "st": 0,
     * "pl": 0,
     * "dl": 0,
     * "sp": 0,
     * "cp": 0,
     * "subp": 0,
     * "cs": false,
     * "maxbr": 999000,
     * "fl": 0,
     * "toast": false,
     * "flag": 1093,
     * "preSell": false
     * }
     * }
     * ],
     * "relatedInfo": null,
     * "videoUserLiveInfo": null,
     * "vid": "350094536B27EA1A1F18372E7282E5BF",
     * "durationms": 239468,
     * "playTime": 4506621,
     * "praisedCount": 27103,
     * "praised": false,
     * "subscribed": false
     * }
     * },
     * {
     * "type": 1,
     * "displayed": false,
     * "alg": "docIbPref_docIbPref-14316766-video&m164",
     * "extAlg": null,
     * "data": {
     * "alg": "docIbPref_docIbPref-14316766-video&m164",
     * "scm": "1.music-video-timeline.video_timeline.video.181017.-295043608",
     * "threadId": "R_VI_62_5C36C1B8FEA408B65FAEA9D2AE8754D2",
     * "coverUrl": "https://p1.music.126.net/SVgxFRsxp8bAHfl5AXZIIQ==/109951163907191534.jpg",
     * "height": 1080,
     * "width": 1920,
     * "title": "【IU直拍】190302 IU BBIBBI 现场舞台",
     * "description": "【IU直拍】190302 IU BBIBBI 现场舞台",
     * "commentCount": 51,
     * "shareCount": 281,
     * "resolutions": [
     * {
     * "resolution": 240,
     * "size": 35279661
     * },
     * {
     * "resolution": 480,
     * "size": 54672676
     * },
     * {
     * "resolution": 720,
     * "size": 85536769
     * },
     * {
     * "resolution": 1080,
     * "size": 143154183
     * }
     * ],
     * "creator": {
     * "defaultAvatar": false,
     * "province": 310000,
     * "authStatus": 0,
     * "followed": false,
     * "avatarUrl": "http://p1.music.126.net/PfAjGOrYTepLWBELSrhSWg==/109951163981832642.jpg",
     * "accountStatus": 0,
     * "gender": 2,
     * "city": 310101,
     * "birthday": 848419200000,
     * "userId": 35672686,
     * "userType": 201,
     * "nickname": "Kpop现场舞台",
     * "signature": "更新现场舞台、混剪视频等，喜欢就关注吧，欢迎私信聊骚。",
     * "description": "",
     * "detailDescription": "",
     * "avatarImgId": 109951163981832640,
     * "backgroundImgId": 109951163981827860,
     * "backgroundUrl": "http://p1.music.126.net/6psTiF36TwQ4cPW8TgU0Fg==/109951163981827851.jpg",
     * "authority": 0,
     * "mutual": false,
     * "expertTags": null,
     * "experts": {
     * "1": "舞蹈视频达人"
     * },
     * "djStatus": 10,
     * "vipType": 0,
     * "remarkName": null,
     * "backgroundImgIdStr": "109951163981827851",
     * "avatarImgIdStr": "109951163981832642",
     * "avatarImgId_str": "109951163981832642"
     * },
     * "urlInfo": {
     * "id": "5C36C1B8FEA408B65FAEA9D2AE8754D2",
     * "url": "http://vodkgeyttp9.vod.126.net/vodkgeyttp8/oh9bK8lG_2357089160_uhd.mp4?ts=1586008474&rid=ADE170238E2BB5B419E8C97E6D969580&rl=3&rs=LDYVSFGgMtPxmiFwETFKvjOlVwtLWaWS&sign=1a161a2b8a52eaa5f1b3dfe11b2570f7&ext=ouMSTmLFIIIlnPYK2G1X9ICzLsix6snlIQgdOvuL7xtQpaM73HYFpSiqnn5qwVvT8B45dzJHSNdWBlr3pFcKLl2Q9%2FSd10VVzoyq4IRBsjHurF%2FlXrRLbfhZ3TKKoPu0llX%2BLe2J%2FQB5q7ait%2BaFXsZrE5MFjMcHzUC8%2F5HWpEouFIjMtpQJp7gs4g70MVKaEgGEt9Gh8cW%2FDIbrIvA9Hs5AhJwtXz2Qhl7%2F3ZKVPbdiGIxn9VGL0tfDXi2yjPbL",
     * "size": 143154183,
     * "validityTime": 1200,
     * "needPay": false,
     * "payInfo": null,
     * "r": 1080
     * },
     * "videoGroup": [
     * {
     * "id": -25553,
     * "name": "#韩语 | 前奏跪 × 开口脆#",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 24113,
     * "name": "IU",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57107,
     * "name": "韩语现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 59108,
     * "name": "巡演现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 57108,
     * "name": "流行现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 1100,
     * "name": "音乐现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 58100,
     * "name": "现场",
     * "alg": "groupTagRank"
     * },
     * {
     * "id": 5100,
     * "name": "音乐",
     * "alg": "groupTagRank"
     * }
     * ],
     * "previewUrl": null,
     * "previewDurationms": 0,
     * "hasRelatedGameAd": false,
     * "markTypes": [
     * 101
     * ],
     * "relateSong": [
     * {
     * "name": "삐삐",
     * "id": 1316563427,
     * "pst": 0,
     * "t": 0,
     * "ar": [
     * {
     * "id": 160947,
     * "name": "IU",
     * "tns": [],
     * "alias": []
     * }
     * ],
     * "alia": [],
     * "pop": 100,
     * "st": 0,
     * "rt": null,
     * "fee": 8,
     * "v": 10,
     * "crbt": null,
     * "cf": "",
     * "al": {
     * "id": 73835728,
     * "name": "삐삐",
     * "picUrl": "http://p1.music.126.net/gxo54B2ypqq0Y6tmahBnIw==/109951163596240238.jpg",
     * "tns": [
     * "BBIBBI"
     * ],
     * "pic_str": "109951163596240238",
     * "pic": 109951163596240240
     * },
     * "dt": 194426,
     * "h": {
     * "br": 320000,
     * "fid": 0,
     * "size": 7779309,
     * "vd": -36000
     * },
     * "m": {
     * "br": 192000,
     * "fid": 0,
     * "size": 4667603,
     * "vd": -33200
     * },
     * "l": {
     * "br": 128000,
     * "fid": 0,
     * "size": 3111750,
     * "vd": -31600
     * },
     * "a": null,
     * "cd": "1",
     * "no": 1,
     * "rtUrl": null,
     * "ftype": 0,
     * "rtUrls": [],
     * "djId": 0,
     * "copyright": 0,
     * "s_id": 0,
     * "rtype": 0,
     * "rurl": null,
     * "mst": 9,
     * "cp": 1410822,
     * "mv": 10799918,
     * "publishTime": 1539100800007,
     * "tns": [
     * "BBIBBI"
     * ],
     * "privilege": {
     * "id": 1316563427,
     * "fee": 8,
     * "payed": 0,
     * "st": 0,
     * "pl": 128000,
     * "dl": 0,
     * "sp": 7,
     * "cp": 1,
     * "subp": 1,
     * "cs": false,
     * "maxbr": 999000,
     * "fl": 128000,
     * "toast": false,
     * "flag": 68,
     * "preSell": false
     * }
     * }
     * ],
     * "relatedInfo": null,
     * "videoUserLiveInfo": null,
     * "vid": "5C36C1B8FEA408B65FAEA9D2AE8754D2",
     * "durationms": 195489,
     * "playTime": 160393,
     * "praisedCount": 1137,
     * "praised": false,
     * "subscribed": false
     * }
     * }
     * ],
     * "rcmdLimit": 0
     * }
     */
    private String msg;
    private int code;
    private boolean hasmore;
    private List<VideoEntity> datas;
    private int rcmdLimit;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setHasmore(boolean hasmore) {
        this.hasmore = hasmore;
    }

    public boolean getHasmore() {
        return hasmore;
    }

    public void setDatas(List<VideoEntity> datas) {
        this.datas = datas;
    }

    public List<VideoEntity> getDatas() {
        return datas;
    }

    public void setRcmdlimit(int rcmdlimit) {
        this.rcmdLimit = rcmdlimit;
    }

    public int getRcmdlimit() {
        return rcmdLimit;
    }

    public static class Experts {

        private String name;

        public void set1(String name) {
            this.name = name;
        }

        public String get1() {
            return name;
        }

    }

    public class Creator {

        private boolean defaultAvatar;
        private int province;
        private int authStatus;
        private boolean followed;
        private String avatarUrl;
        private int accountStatus;
        private int gender;
        private int city;
        private String birthday;
        private long userId;
        private int userType;
        private String nickname;
        private String signature;
        private String description;
        private String detailDescription;
        private String avatarImgId;
        private String backgroundImgId;
        private String backgroundUrl;
        private int authority;
        private boolean mutual;
        private Object expertTags;
        private Experts experts;
        private int djStatus;
        private int vipType;
        private String remarkName;
        private String backgroundImgIdStr;
        private String avatarImgIdStr;
        private String avatarImgId_str;

        public void setDefaultavatar(boolean defaultavatar) {
            this.defaultAvatar = defaultavatar;
        }

        public boolean getDefaultavatar() {
            return defaultAvatar;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public int getProvince() {
            return province;
        }

        public void setAuthstatus(int authstatus) {
            this.authStatus = authstatus;
        }

        public int getAuthstatus() {
            return authStatus;
        }

        public void setFollowed(boolean followed) {
            this.followed = followed;
        }

        public boolean getFollowed() {
            return followed;
        }

        public void setAvatarurl(String avatarurl) {
            this.avatarUrl = avatarurl;
        }

        public String getAvatarurl() {
            return avatarUrl;
        }

        public void setAccountstatus(int accountstatus) {
            this.accountStatus = accountstatus;
        }

        public int getAccountstatus() {
            return accountStatus;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public int getGender() {
            return gender;
        }

        public void setCity(int city) {
            this.city = city;
        }

        public int getCity() {
            return city;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setUserid(long userid) {
            this.userId = userid;
        }

        public long getUserid() {
            return userId;
        }

        public void setUsertype(int usertype) {
            this.userType = usertype;
        }

        public int getUsertype() {
            return userType;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getNickname() {
            return nickname;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

        public String getSignature() {
            return signature;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setDetaildescription(String detaildescription) {
            this.detailDescription = detaildescription;
        }

        public String getDetaildescription() {
            return detailDescription;
        }

        public void setAvatarimgid(String avatarimgid) {
            this.avatarImgId = avatarimgid;
        }

        public String getAvatarimgid() {
            return avatarImgId;
        }

        public void setBackgroundimgid(String backgroundimgid) {
            this.backgroundImgId = backgroundimgid;
        }

        public String getBackgroundimgid() {
            return backgroundImgId;
        }

        public void setBackgroundurl(String backgroundurl) {
            this.backgroundUrl = backgroundurl;
        }

        public String getBackgroundurl() {
            return backgroundUrl;
        }

        public void setAuthority(int authority) {
            this.authority = authority;
        }

        public int getAuthority() {
            return authority;
        }

        public void setMutual(boolean mutual) {
            this.mutual = mutual;
        }

        public boolean getMutual() {
            return mutual;
        }

        public void setExperttags(Object experttags) {
            this.expertTags = experttags;
        }

        public Object getExperttags() {
            return expertTags;
        }

        public void setExperts(Experts experts) {
            this.experts = experts;
        }

        public Experts getExperts() {
            return experts;
        }

        public void setDjstatus(int djstatus) {
            this.djStatus = djstatus;
        }

        public int getDjstatus() {
            return djStatus;
        }

        public void setViptype(int viptype) {
            this.vipType = viptype;
        }

        public int getViptype() {
            return vipType;
        }

        public void setRemarkname(String remarkname) {
            this.remarkName = remarkname;
        }

        public String getRemarkname() {
            return remarkName;
        }

        public void setBackgroundimgidstr(String backgroundimgidstr) {
            this.backgroundImgIdStr = backgroundimgidstr;
        }

        public String getBackgroundimgidstr() {
            return backgroundImgIdStr;
        }

        public void setAvatarimgidstr(String avatarimgidstr) {
            this.avatarImgIdStr = avatarimgidstr;
        }

        public String getAvatarimgidstr() {
            return avatarImgIdStr;
        }

        public void setAvatarimgidStr(String avatarimgidStr) {
            this.avatarImgIdStr = avatarimgidStr;
        }

        public String getAvatarimgidStr() {
            return avatarImgIdStr;
        }

    }

    public static class Urlinfo {

        private String id;
        private String url;
        private int size;
        private int validityTime;
        private boolean needPay;
        private String payInfo;
        private int r;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

        public void setValiditytime(int validitytime) {
            this.validityTime = validitytime;
        }

        public int getValiditytime() {
            return validityTime;
        }

        public void setNeedpay(boolean needpay) {
            this.needPay = needpay;
        }

        public boolean getNeedpay() {
            return needPay;
        }

        public void setPayinfo(String payinfo) {
            this.payInfo = payinfo;
        }

        public String getPayinfo() {
            return payInfo;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getR() {
            return r;
        }

    }

    public static class Videogroup {

        private int id;
        private String name;
        private String alg;

        public void setId(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getAlg() {
            return alg;
        }

    }

    public class Data {

        private String alg;
        private String scm;
        //评论
        private String threadId;
        private String coverUrl;
        private int height;
        private int width;
        private String title;
        //详情
        private String description;
        //评论数量
        private int commentCount;
        //分享数量
        private int shareCount;
        private int subscribeCount;
        private List<Resolutions> resolutions;
        //作者
        private Creator creator;
        private Urlinfo urlInfo;
        //相关组
        private List<Videogroup> videoGroup;
        private String previewUrl;
        private int previewDurationms;
        private boolean hasRelatedGameAd;
        private Object markTypes;
        //相关歌曲
        private List<SongDetailBean.SongsBean> relateSong;
        private String relatedInfo;
        private String videoUserLiveInfo;
        private String vid;
        private int durationms;
        private int playTime;
        //点赞数量
        private int praisedCount;
        private boolean praised;
        private boolean subscribed;

        public String getSubscribeCount() {
            return String.valueOf(subscribeCount);
        }

        public void setSubscribeCount(int subscribeCount) {
            this.subscribeCount = subscribeCount;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getAlg() {
            return alg;
        }

        public void setScm(String scm) {
            this.scm = scm;
        }

        public String getScm() {
            return scm;
        }

        public void setThreadid(String threadid) {
            this.threadId = threadid;
        }

        public String getThreadid() {
            return threadId;
        }

        public void setCoverurl(String coverurl) {
            this.coverUrl = coverurl;
        }

        public String getCoverurl() {
            return coverUrl;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setCommentcount(int commentcount) {
            this.commentCount = commentcount;
        }

        public String getCommentcount() {
            return String.valueOf(commentCount);
        }

        public void setSharecount(int sharecount) {
            this.shareCount = sharecount;
        }

        public String getSharecount() {
            return String.valueOf(shareCount);
        }

        public void setResolutions(List<Resolutions> resolutions) {
            this.resolutions = resolutions;
        }

        public List<Resolutions> getResolutions() {
            return resolutions;
        }

        public void setCreator(Creator creator) {
            this.creator = creator;
        }

        public Creator getCreator() {
            return creator;
        }

        public void setUrlinfo(Urlinfo urlinfo) {
            this.urlInfo = urlinfo;
        }

        public Urlinfo getUrlinfo() {
            return urlInfo;
        }

        public void setVideogroup(List<Videogroup> videogroup) {
            this.videoGroup = videogroup;
        }

        public List<Videogroup> getVideogroup() {
            return videoGroup;
        }

        public void setPreviewurl(String previewurl) {
            this.previewUrl = previewurl;
        }

        public String getPreviewurl() {
            return previewUrl;
        }

        public void setPreviewdurationms(int previewdurationms) {
            this.previewDurationms = previewdurationms;
        }

        public int getPreviewdurationms() {
            return previewDurationms;
        }

        public void setHasrelatedgamead(boolean hasrelatedgamead) {
            this.hasRelatedGameAd = hasrelatedgamead;
        }

        public boolean getHasrelatedgamead() {
            return hasRelatedGameAd;
        }

        public void setMarktypes(Object marktypes) {
            this.markTypes = marktypes;
        }

        public Object getMarktypes() {
            return markTypes;
        }

        public void setRelatesong(List<SongDetailBean.SongsBean> relatesong) {
            this.relateSong = relatesong;
        }

        public List<SongDetailBean.SongsBean> getRelatesong() {
            return relateSong;
        }

        public void setRelatedinfo(String relatedinfo) {
            this.relatedInfo = relatedinfo;
        }

        public String getRelatedinfo() {
            return relatedInfo;
        }

        public void setVideouserliveinfo(String videouserliveinfo) {
            this.videoUserLiveInfo = videouserliveinfo;
        }

        public String getVideouserliveinfo() {
            return videoUserLiveInfo;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVid() {
            return vid;
        }

        public void setDurationms(int durationms) {
            this.durationms = durationms;
        }

        public int getDurationms() {
            return durationms;
        }

        public void setPlaytime(int playtime) {
            this.playTime = playtime;
        }

        public int getPlaytime() {
            return playTime;
        }

        public void setPraisedcount(int praisedcount) {
            this.praisedCount = praisedcount;
        }

        public String getPraisedcount() {
            return String.valueOf(praisedCount);
        }

        public void setPraised(boolean praised) {
            this.praised = praised;
        }

        public boolean getPraised() {
            return praised;
        }

        public void setSubscribed(boolean subscribed) {
            this.subscribed = subscribed;
        }

        public boolean getSubscribed() {
            return subscribed;
        }

    }

    public class VideoEntity {

        private int type;
        private boolean displayed;
        private String alg;
        private String extAlg;
        private Data data;

        public void setType(int type) {
            this.type = type;
        }

        public int getType() {
            return type;
        }

        public void setDisplayed(boolean displayed) {
            this.displayed = displayed;
        }

        public boolean getDisplayed() {
            return displayed;
        }

        public void setAlg(String alg) {
            this.alg = alg;
        }

        public String getAlg() {
            return alg;
        }

        public void setExtalg(String extalg) {
            this.extAlg = extalg;
        }

        public String getExtalg() {
            return extAlg;
        }

        public void setData(Data data) {
            this.data = data;
        }

        public Data getData() {
            return data;
        }

    }

    public static class Resolutions {

        private int resolution;
        private int size;

        public void setResolution(int resolution) {
            this.resolution = resolution;
        }

        public int getResolution() {
            return resolution;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getSize() {
            return size;
        }

    }
}
