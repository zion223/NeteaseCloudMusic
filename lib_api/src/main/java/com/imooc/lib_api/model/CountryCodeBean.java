package com.imooc.lib_api.model;

import java.util.List;

/**
 * {
 * "code": 200,
 * "message": "success",
 * "data": [
 * {
 * "label": "常用",
 * "countryList": [
 * {
 * "zh": "中国",
 * "en": "China",
 * "locale": "CN",
 * "code": "86"
 * },
 * {
 * "zh": "中国香港",
 * "en": "Hongkong",
 * "locale": "HK",
 * "code": "852"
 * },
 * {
 * "zh": "中国澳门",
 * "en": "Macao",
 * "locale": "MO",
 * "code": "853"
 * },
 * {
 * "zh": "中国台湾",
 * "en": "Taiwan",
 * "locale": "TW",
 * "code": "886"
 * }
 * ]
 * },
 * {
 * "label": "A",
 * "countryList": [
 * {
 * "zh": "阿尔巴尼亚",
 * "en": "Albania",
 * "locale": "AL",
 * "code": "355"
 * },
 * {
 * "zh": "阿尔及利亚",
 * "en": "Algeria",
 * "locale": "DZ",
 * "code": "213"
 * },
 * {
 * "zh": "阿富汗",
 * "en": "Afghanistan",
 * "locale": "AF",
 * "code": "93"
 * },
 * {
 * "zh": "阿根廷",
 * "en": "Argentina",
 * "locale": "AR",
 * "code": "54"
 * },
 * {
 * "zh": "阿拉伯联合酋长国",
 * "en": "United Arab Emirates",
 * "locale": "AE",
 * "code": "971"
 * },
 * {
 * "zh": "阿曼",
 * "en": "Oman",
 * "locale": "OM",
 * "code": "968"
 * },
 * {
 * "zh": "阿塞拜疆",
 * "en": "Azerbaijan",
 * "locale": "AZ",
 * "code": "994"
 * },
 * {
 * "zh": "阿森松",
 * "en": "Ascension",
 * "locale": "AC",
 * "code": "247"
 * },
 * {
 * "zh": "埃及",
 * "en": "Egypt",
 * "locale": "EG",
 * "code": "20"
 * },
 * {
 * "zh": "埃塞俄比亚",
 * "en": "Ethiopia",
 * "locale": "ET",
 * "code": "251"
 * },
 * {
 * "zh": "爱尔兰",
 * "en": "Ireland",
 * "locale": "IE",
 * "code": "353"
 * },
 * {
 * "zh": "爱沙尼亚",
 * "en": "Estonia",
 * "locale": "EE",
 * "code": "372"
 * },
 * {
 * "zh": "安道尔共和国",
 * "en": "Andorra",
 * "locale": "AD",
 * "code": "376"
 * },
 * {
 * "zh": "安哥拉",
 * "en": "Angola",
 * "locale": "AO",
 * "code": "244"
 * },
 * {
 * "zh": "安圭拉岛",
 * "en": "Anguilla",
 * "locale": "AI",
 * "code": "1264"
 * },
 * {
 * "zh": "安提瓜和巴布达",
 * "en": "Antigua and Barbuda",
 * "locale": "AG",
 * "code": "1268"
 * },
 * {
 * "zh": "奥地利",
 * "en": "Austria",
 * "locale": "AT",
 * "code": "43"
 * },
 * {
 * "zh": "澳大利亚",
 * "en": "Australia",
 * "locale": "AU",
 * "code": "61"
 * }
 * ]
 * },
 * {
 * "label": "B",
 * "countryList": [
 * {
 * "zh": "巴巴多斯",
 * "en": "Barbados",
 * "locale": "BB",
 * "code": "1246"
 * },
 * {
 * "zh": "巴布亚新几内亚",
 * "en": "Papua New Cuinea",
 * "locale": "PG",
 * "code": "675"
 * },
 * {
 * "zh": "巴哈马",
 * "en": "Bahamas",
 * "locale": "BS",
 * "code": "1242"
 * },
 * {
 * "zh": "巴基斯坦",
 * "en": "Pakistan",
 * "locale": "PK",
 * "code": "92"
 * },
 * {
 * "zh": "巴拉圭",
 * "en": "Paraguay",
 * "locale": "PY",
 * "code": "595"
 * },
 * {
 * "zh": "巴林",
 * "en": "Bahrain",
 * "locale": "BH",
 * "code": "973"
 * },
 * {
 * "zh": "巴拿马",
 * "en": "Panama",
 * "locale": "PA",
 * "code": "507"
 * },
 * {
 * "zh": "巴西",
 * "en": "Brazil",
 * "locale": "BR",
 * "code": "55"
 * },
 * {
 * "zh": "白俄罗斯",
 * "en": "Belarus",
 * "locale": "BY",
 * "code": "375"
 * },
 * {
 * "zh": "百慕大群岛",
 * "en": "BermudaIs.",
 * "locale": "BM",
 * "code": "1441"
 * },
 * {
 * "zh": "保加利亚",
 * "en": "Bulgaria",
 * "locale": "BG",
 * "code": "359"
 * },
 * {
 * "zh": "北马里亚纳群岛",
 * "en": "Northern Mariana Is",
 * "locale": "MP",
 * "code": "1670"
 * },
 * {
 * "zh": "贝宁",
 * "en": "Benin",
 * "locale": "BJ",
 * "code": "229"
 * },
 * {
 * "zh": "比利时",
 * "en": "Belgium",
 * "locale": "BE",
 * "code": "32"
 * },
 * {
 * "zh": "冰岛",
 * "en": "Iceland",
 * "locale": "IS",
 * "code": "354"
 * },
 * {
 * "zh": "波多黎各",
 * "en": "PuertoRico",
 * "locale": "PR",
 * "code": "1787"
 * },
 * {
 * "zh": "波兰",
 * "en": "Poland",
 * "locale": "PL",
 * "code": "48"
 * },
 * {
 * "zh": "玻利维亚",
 * "en": "Bolivia",
 * "locale": "BO",
 * "code": "591"
 * },
 * {
 * "zh": "伯利兹",
 * "en": "Belize",
 * "locale": "BZ",
 * "code": "501"
 * },
 * {
 * "zh": "博茨瓦纳",
 * "en": "Botswana",
 * "locale": "BW",
 * "code": "267"
 * },
 * {
 * "zh": "布基纳法索",
 * "en": "Burkina-faso",
 * "locale": "BF",
 * "code": "226"
 * },
 * {
 * "zh": "布隆迪",
 * "en": "Burundi",
 * "locale": "BI",
 * "code": "257"
 * }
 * ]
 * },
 * {
 * "label": "C",
 * "countryList": [
 * {
 * "zh": "朝鲜",
 * "en": "North Korea",
 * "locale": "KP",
 * "code": "850"
 * }
 * ]
 * },
 * {
 * "label": "D",
 * "countryList": [
 * {
 * "zh": "丹麦",
 * "en": "Denmark",
 * "locale": "DK",
 * "code": "45"
 * },
 * {
 * "zh": "德国",
 * "en": "Germany",
 * "locale": "DE",
 * "code": "49"
 * },
 * {
 * "zh": "东萨摩亚",
 * "en": "Samoa Eastern",
 * "locale": "AS",
 * "code": "684"
 * },
 * {
 * "zh": "多哥",
 * "en": "Togo",
 * "locale": "TG",
 * "code": "228"
 * },
 * {
 * "zh": "多米尼加共和国",
 * "en": "Dominica Rep.",
 * "locale": "DO",
 * "code": "1809"
 * }
 * ]
 * },
 * {
 * "label": "E",
 * "countryList": [
 * {
 * "zh": "俄罗斯",
 * "en": "Russia",
 * "locale": "RU",
 * "code": "7"
 * },
 * {
 * "zh": "厄瓜多尔",
 * "en": "Ecuador",
 * "locale": "EC",
 * "code": "593"
 * }
 * ]
 * },
 * {
 * "label": "F",
 * "countryList": [
 * {
 * "zh": "法国",
 * "en": "France",
 * "locale": "FR",
 * "code": "33"
 * },
 * {
 * "zh": "法属玻利尼西亚",
 * "en": "French Polynesia",
 * "locale": "PF",
 * "code": "689"
 * },
 * {
 * "zh": "法属圭亚那",
 * "en": "French Guiana",
 * "locale": "GF",
 * "code": "594"
 * },
 * {
 * "zh": "菲律宾",
 * "en": "Philippines",
 * "locale": "PH",
 * "code": "63"
 * },
 * {
 * "zh": "斐济",
 * "en": "Fiji",
 * "locale": "FJ",
 * "code": "679"
 * },
 * {
 * "zh": "芬兰",
 * "en": "Finland",
 * "locale": "FI",
 * "code": "358"
 * }
 * ]
 * },
 * {
 * "label": "G",
 * "countryList": [
 * {
 * "zh": "冈比亚",
 * "en": "Gambia",
 * "locale": "GM",
 * "code": "220"
 * },
 * {
 * "zh": "刚果",
 * "en": "Congo",
 * "locale": "CG",
 * "code": "242"
 * },
 * {
 * "zh": "刚果民主共和国",
 * "en": "DR Congo",
 * "locale": "CD",
 * "code": "243"
 * },
 * {
 * "zh": "哥伦比亚",
 * "en": "Colombia",
 * "locale": "CO",
 * "code": "57"
 * },
 * {
 * "zh": "哥斯达黎加",
 * "en": "Costa Rica",
 * "locale": "CR",
 * "code": "506"
 * },
 * {
 * "zh": "格林纳达",
 * "en": "Grenada",
 * "locale": "GD",
 * "code": "1473"
 * },
 * {
 * "zh": "格鲁吉亚",
 * "en": "Georgia",
 * "locale": "GE",
 * "code": "995"
 * },
 * {
 * "zh": "古巴",
 * "en": "Cuba",
 * "locale": "CU",
 * "code": "53"
 * },
 * {
 * "zh": "关岛",
 * "en": "Guam",
 * "locale": "GU",
 * "code": "1671"
 * },
 * {
 * "zh": "圭亚那",
 * "en": "Guyana",
 * "locale": "GY",
 * "code": "592"
 * }
 * ]
 * },
 * {
 * "label": "H",
 * "countryList": [
 * {
 * "zh": "哈萨克斯坦",
 * "en": "Kazakstan",
 * "locale": "KZ",
 * "code": "7"
 * },
 * {
 * "zh": "海地",
 * "en": "Haiti",
 * "locale": "HT",
 * "code": "509"
 * },
 * {
 * "zh": "韩国",
 * "en": "Korea",
 * "locale": "KR",
 * "code": "82"
 * },
 * {
 * "zh": "荷兰",
 * "en": "Netherlands",
 * "locale": "NL",
 * "code": "31"
 * },
 * {
 * "zh": "洪都拉斯",
 * "en": "Honduras",
 * "locale": "HN",
 * "code": "504"
 * }
 * ]
 * },
 * {
 * "label": "J",
 * "countryList": [
 * {
 * "zh": "吉布提",
 * "en": "Djibouti",
 * "locale": "DJ",
 * "code": "253"
 * },
 * {
 * "zh": "吉尔吉斯坦",
 * "en": "Kyrgyzstan",
 * "locale": "KG",
 * "code": "996"
 * },
 * {
 * "zh": "几内亚",
 * "en": "Guinea",
 * "locale": "GN",
 * "code": "224"
 * },
 * {
 * "zh": "加拿大",
 * "en": "Canada",
 * "locale": "CA",
 * "code": "1"
 * },
 * {
 * "zh": "加纳",
 * "en": "Ghana",
 * "locale": "GH",
 * "code": "233"
 * },
 * {
 * "zh": "加蓬",
 * "en": "Gabon",
 * "locale": "GA",
 * "code": "241"
 * },
 * {
 * "zh": "柬埔寨",
 * "en": "Kampuchea (Cambodia )",
 * "locale": "KH",
 * "code": "855"
 * },
 * {
 * "zh": "捷克",
 * "en": "Czech Republic",
 * "locale": "CZ",
 * "code": "420"
 * },
 * {
 * "zh": "津巴布韦",
 * "en": "Zimbabwe",
 * "locale": "ZW",
 * "code": "263"
 * }
 * ]
 * },
 * {
 * "label": "K",
 * "countryList": [
 * {
 * "zh": "喀麦隆",
 * "en": "Cameroon",
 * "locale": "CM",
 * "code": "237"
 * },
 * {
 * "zh": "卡塔尔",
 * "en": "Qatar",
 * "locale": "QA",
 * "code": "974"
 * },
 * {
 * "zh": "开曼群岛",
 * "en": "Cayman Is.",
 * "locale": "KY",
 * "code": "1345"
 * },
 * {
 * "zh": "科特迪瓦",
 * "en": "IvoryCoast",
 * "locale": "CI",
 * "code": "225"
 * },
 * {
 * "zh": "科威特",
 * "en": "Kuwait",
 * "locale": "KW",
 * "code": "965"
 * },
 * {
 * "zh": "肯尼亚",
 * "en": "Kenya",
 * "locale": "KE",
 * "code": "254"
 * },
 * {
 * "zh": "库克群岛",
 * "en": "Cook Is.",
 * "locale": "CK",
 * "code": "682"
 * }
 * ]
 * },
 * {
 * "label": "L",
 * "countryList": [
 * {
 * "zh": "拉脱维亚",
 * "en": "Latvia",
 * "locale": "LV",
 * "code": "371"
 * },
 * {
 * "zh": "莱索托",
 * "en": "Lesotho",
 * "locale": "LS",
 * "code": "266"
 * },
 * {
 * "zh": "老挝",
 * "en": "Laos",
 * "locale": "LA",
 * "code": "856"
 * },
 * {
 * "zh": "黎巴嫩",
 * "en": "Lebanon",
 * "locale": "LB",
 * "code": "961"
 * },
 * {
 * "zh": "立陶宛",
 * "en": "Lithuania",
 * "locale": "LT",
 * "code": "370"
 * },
 * {
 * "zh": "利比里亚",
 * "en": "Liberia",
 * "locale": "LR",
 * "code": "231"
 * },
 * {
 * "zh": "利比亚",
 * "en": "Libya",
 * "locale": "LY",
 * "code": "218"
 * },
 * {
 * "zh": "列支敦士登",
 * "en": "Liechtenstein",
 * "locale": "LI",
 * "code": "423"
 * },
 * {
 * "zh": "留尼旺",
 * "en": "Reunion",
 * "locale": "RE",
 * "code": "262"
 * },
 * {
 * "zh": "卢森堡",
 * "en": "Luxembourg",
 * "locale": "LU",
 * "code": "352"
 * },
 * {
 * "zh": "罗马尼亚",
 * "en": "Romania",
 * "locale": "RO",
 * "code": "40"
 * }
 * ]
 * },
 * {
 * "label": "M",
 * "countryList": [
 * {
 * "zh": "马达加斯加",
 * "en": "Madagascar",
 * "locale": "MG",
 * "code": "261"
 * },
 * {
 * "zh": "马尔代夫",
 * "en": "Maldives",
 * "locale": "MV",
 * "code": "960"
 * },
 * {
 * "zh": "马耳他",
 * "en": "Malta",
 * "locale": "MT",
 * "code": "356"
 * },
 * {
 * "zh": "马拉维",
 * "en": "Malawi",
 * "locale": "MW",
 * "code": "265"
 * },
 * {
 * "zh": "马来西亚",
 * "en": "Malaysia",
 * "locale": "MY",
 * "code": "60"
 * },
 * {
 * "zh": "马里",
 * "en": "Mali",
 * "locale": "ML",
 * "code": "223"
 * },
 * {
 * "zh": "马提尼克",
 * "en": "Martinique",
 * "locale": "MQ",
 * "code": "596"
 * },
 * {
 * "zh": "毛里求斯",
 * "en": "Mauritius",
 * "locale": "MU",
 * "code": "230"
 * },
 * {
 * "zh": "美国",
 * "en": "United States of America",
 * "locale": "US",
 * "code": "1"
 * },
 * {
 * "zh": "蒙古",
 * "en": "Mongolia",
 * "locale": "MN",
 * "code": "976"
 * },
 * {
 * "zh": "蒙特塞拉特岛",
 * "en": "Montserrat Is",
 * "locale": "MS",
 * "code": "1664"
 * },
 * {
 * "zh": "孟加拉国",
 * "en": "Bangladesh",
 * "locale": "BD",
 * "code": "880"
 * },
 * {
 * "zh": "秘鲁",
 * "en": "Peru",
 * "locale": "PE",
 * "code": "51"
 * },
 * {
 * "zh": "缅甸",
 * "en": "Burma",
 * "locale": "MM",
 * "code": "95"
 * },
 * {
 * "zh": "摩尔多瓦",
 * "en": "Republic of Moldova",
 * "locale": "MD",
 * "code": "373"
 * },
 * {
 * "zh": "摩洛哥",
 * "en": "Morocco",
 * "locale": "MA",
 * "code": "212"
 * },
 * {
 * "zh": "摩纳哥",
 * "en": "Monaco",
 * "locale": "MC",
 * "code": "377"
 * },
 * {
 * "zh": "莫桑比克",
 * "en": "Mozambique",
 * "locale": "MZ",
 * "code": "258"
 * },
 * {
 * "zh": "墨西哥",
 * "en": "Mexico",
 * "locale": "MX",
 * "code": "52"
 * }
 * ]
 * },
 * {
 * "label": "N",
 * "countryList": [
 * {
 * "zh": "纳米比亚",
 * "en": "Namibia",
 * "locale": "NA",
 * "code": "264"
 * },
 * {
 * "zh": "南非",
 * "en": "South Africa",
 * "locale": "ZA",
 * "code": "27"
 * },
 * {
 * "zh": "瑙鲁",
 * "en": "Nauru",
 * "locale": "NR",
 * "code": "674"
 * },
 * {
 * "zh": "尼泊尔",
 * "en": "Nepal",
 * "locale": "NP",
 * "code": "977"
 * },
 * {
 * "zh": "尼加拉瓜",
 * "en": "Nicaragua",
 * "locale": "NI",
 * "code": "505"
 * },
 * {
 * "zh": "尼日尔",
 * "en": "Niger",
 * "locale": "NE",
 * "code": "227"
 * },
 * {
 * "zh": "尼日利亚",
 * "en": "Nigeria",
 * "locale": "NG",
 * "code": "234"
 * },
 * {
 * "zh": "挪威",
 * "en": "Norway",
 * "locale": "NO",
 * "code": "47"
 * }
 * ]
 * },
 * {
 * "label": "P",
 * "countryList": [
 * {
 * "zh": "葡萄牙",
 * "en": "Portugal",
 * "locale": "PT",
 * "code": "351"
 * }
 * ]
 * },
 * {
 * "label": "R",
 * "countryList": [
 * {
 * "zh": "日本",
 * "en": "Japan",
 * "locale": "JP",
 * "code": "81"
 * },
 * {
 * "zh": "瑞典",
 * "en": "Sweden",
 * "locale": "SE",
 * "code": "46"
 * },
 * {
 * "zh": "瑞士",
 * "en": "Switzerland",
 * "locale": "CH",
 * "code": "41"
 * }
 * ]
 * },
 * {
 * "label": "S",
 * "countryList": [
 * {
 * "zh": "萨尔瓦多",
 * "en": "EISalvador",
 * "locale": "SV",
 * "code": "503"
 * },
 * {
 * "zh": "塞拉利昂",
 * "en": "Sierra Leone",
 * "locale": "SL",
 * "code": "232"
 * },
 * {
 * "zh": "塞内加尔",
 * "en": "Senegal",
 * "locale": "SN",
 * "code": "221"
 * },
 * {
 * "zh": "塞浦路斯",
 * "en": "Cyprus",
 * "locale": "CY",
 * "code": "357"
 * },
 * {
 * "zh": "塞舌尔",
 * "en": "Seychelles",
 * "locale": "SC",
 * "code": "248"
 * },
 * {
 * "zh": "沙特阿拉伯",
 * "en": "Saudi Arabia",
 * "locale": "SA",
 * "code": "966"
 * },
 * {
 * "zh": "圣多美和普林西比",
 * "en": "Sao Tome and Principe",
 * "locale": "ST",
 * "code": "239"
 * },
 * {
 * "zh": "圣卢西亚",
 * "en": "Saint Lucia",
 * "locale": "LC",
 * "code": "1758"
 * },
 * {
 * "zh": "圣马力诺",
 * "en": "San Marino",
 * "locale": "SM",
 * "code": "378"
 * },
 * {
 * "zh": "圣文森特岛",
 * "en": "Saint Vincent",
 * "locale": "VC",
 * "code": "1784"
 * },
 * {
 * "zh": "斯里兰卡",
 * "en": "Sri Lanka",
 * "locale": "LK",
 * "code": "94"
 * },
 * {
 * "zh": "斯洛伐克",
 * "en": "Slovakia",
 * "locale": "SK",
 * "code": "421"
 * },
 * {
 * "zh": "斯洛文尼亚",
 * "en": "Slovenia",
 * "locale": "SI",
 * "code": "386"
 * },
 * {
 * "zh": "斯威士兰",
 * "en": "Swaziland",
 * "locale": "SZ",
 * "code": "268"
 * },
 * {
 * "zh": "苏丹",
 * "en": "Sudan",
 * "locale": "SD",
 * "code": "249"
 * },
 * {
 * "zh": "苏里南",
 * "en": "Suriname",
 * "locale": "SR",
 * "code": "597"
 * },
 * {
 * "zh": "所罗门群岛",
 * "en": "Solomon Is",
 * "locale": "SB",
 * "code": "677"
 * },
 * {
 * "zh": "索马里",
 * "en": "Somali",
 * "locale": "SO",
 * "code": "252"
 * }
 * ]
 * },
 * {
 * "label": "T",
 * "countryList": [
 * {
 * "zh": "塔吉克斯坦",
 * "en": "Tajikstan",
 * "locale": "TJ",
 * "code": "992"
 * },
 * {
 * "zh": "泰国",
 * "en": "Thailand",
 * "locale": "TH",
 * "code": "66"
 * },
 * {
 * "zh": "坦桑尼亚",
 * "en": "Tanzania",
 * "locale": "TZ",
 * "code": "255"
 * },
 * {
 * "zh": "汤加",
 * "en": "Tonga",
 * "locale": "TO",
 * "code": "676"
 * },
 * {
 * "zh": "特立尼达和多巴哥",
 * "en": "Trinidad and Tobago",
 * "locale": "TT",
 * "code": "1868"
 * },
 * {
 * "zh": "突尼斯",
 * "en": "Tunisia",
 * "locale": "TN",
 * "code": "216"
 * },
 * {
 * "zh": "土耳其",
 * "en": "Turkey",
 * "locale": "TR",
 * "code": "90"
 * },
 * {
 * "zh": "土库曼斯坦",
 * "en": "Turkmenistan",
 * "locale": "TM",
 * "code": "993"
 * }
 * ]
 * },
 * {
 * "label": "W",
 * "countryList": [
 * {
 * "zh": "危地马拉",
 * "en": "Guatemala",
 * "locale": "GT",
 * "code": "502"
 * },
 * {
 * "zh": "委内瑞拉",
 * "en": "Venezuela",
 * "locale": "VE",
 * "code": "58"
 * },
 * {
 * "zh": "文莱",
 * "en": "Brunei",
 * "locale": "BN",
 * "code": "673"
 * },
 * {
 * "zh": "乌干达",
 * "en": "Uganda",
 * "locale": "UG",
 * "code": "256"
 * },
 * {
 * "zh": "乌克兰",
 * "en": "Ukraine",
 * "locale": "UA",
 * "code": "380"
 * },
 * {
 * "zh": "乌拉圭",
 * "en": "Uruguay",
 * "locale": "UY",
 * "code": "598"
 * },
 * {
 * "zh": "乌兹别克斯坦",
 * "en": "Uzbekistan",
 * "locale": "UZ",
 * "code": "998"
 * }
 * ]
 * },
 * {
 * "label": "X",
 * "countryList": [
 * {
 * "zh": "西班牙",
 * "en": "Spain",
 * "locale": "ES",
 * "code": "34"
 * },
 * {
 * "zh": "西萨摩亚",
 * "en": "Samoa Western",
 * "locale": "WS",
 * "code": "685"
 * },
 * {
 * "zh": "希腊",
 * "en": "Greece",
 * "locale": "GR",
 * "code": "30"
 * },
 * {
 * "zh": "新加坡",
 * "en": "Singapore",
 * "locale": "SG",
 * "code": "65"
 * },
 * {
 * "zh": "新西兰",
 * "en": "NewZealand",
 * "locale": "NZ",
 * "code": "64"
 * },
 * {
 * "zh": "匈牙利",
 * "en": "Hungary",
 * "locale": "HU",
 * "code": "36"
 * },
 * {
 * "zh": "叙利亚",
 * "en": "Syria",
 * "locale": "SY",
 * "code": "963"
 * }
 * ]
 * },
 * {
 * "label": "Y",
 * "countryList": [
 * {
 * "zh": "牙买加",
 * "en": "Jamaica",
 * "locale": "JM",
 * "code": "1876"
 * },
 * {
 * "zh": "亚美尼亚",
 * "en": "Armenia",
 * "locale": "AM",
 * "code": "374"
 * },
 * {
 * "zh": "也门",
 * "en": "Yemen",
 * "locale": "YE",
 * "code": "967"
 * },
 * {
 * "zh": "伊拉克",
 * "en": "Iraq",
 * "locale": "IQ",
 * "code": "964"
 * },
 * {
 * "zh": "伊朗",
 * "en": "Iran",
 * "locale": "IR",
 * "code": "98"
 * },
 * {
 * "zh": "以色列",
 * "en": "Israel",
 * "locale": "IL",
 * "code": "972"
 * },
 * {
 * "zh": "意大利",
 * "en": "Italy",
 * "locale": "IT",
 * "code": "39"
 * },
 * {
 * "zh": "印度",
 * "en": "India",
 * "locale": "IN",
 * "code": "91"
 * },
 * {
 * "zh": "印度尼西亚",
 * "en": "Indonesia",
 * "locale": "ID",
 * "code": "62"
 * },
 * {
 * "zh": "英国",
 * "en": "United Kingdom",
 * "locale": "GB",
 * "code": "44"
 * },
 * {
 * "zh": "约旦",
 * "en": "Jordan",
 * "locale": "JO",
 * "code": "962"
 * },
 * {
 * "zh": "越南",
 * "en": "Vietnam",
 * "locale": "VN",
 * "code": "84"
 * }
 * ]
 * },
 * {
 * "label": "Z",
 * "countryList": [
 * {
 * "zh": "赞比亚",
 * "en": "Zambia",
 * "locale": "ZM",
 * "code": "260"
 * },
 * {
 * "zh": "乍得",
 * "en": "Chad",
 * "locale": "TD",
 * "code": "235"
 * },
 * {
 * "zh": "直布罗陀",
 * "en": "Gibraltar",
 * "locale": "GI",
 * "code": "350"
 * },
 * {
 * "zh": "智利",
 * "en": "Chile",
 * "locale": "CL",
 * "code": "56"
 * },
 * {
 * "zh": "中非共和国",
 * "en": "Central African Republic",
 * "locale": "CF",
 * "code": "236"
 * }
 * ]
 * }
 * ]
 * }
 */
public class CountryCodeBean {

    private int code;
    private String message;
    private List<CountryCode> data;

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setData(List<CountryCode> data) {
        this.data = data;
    }

    public List<CountryCode> getData() {
        return data;
    }

    public static class CountryCode {

        private String label;
        private List<CountryList> countryList;

        public void setLabel(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public void setCountryList(List<CountryList> countryList) {
            this.countryList = countryList;
        }

        public List<CountryList> getCountryList() {
            return countryList;
        }

    }

    public static class CountryList {

        private String zh;
        private String en;
        private String locale;
        private String code;

        public void setZh(String zh) {
            this.zh = zh;
        }

        public String getZh() {
            return zh;
        }

        public void setEn(String en) {
            this.en = en;
        }

        public String getEn() {
            return en;
        }

        public void setLocale(String locale) {
            this.locale = locale;
        }

        public String getLocale() {
            return locale;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

    }


}




