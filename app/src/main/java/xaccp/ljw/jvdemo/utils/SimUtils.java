package xaccp.ljw.jvdemo.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by Administrator on 2016/11/18.
 */

public class SimUtils {

    /**
     * 检查SIM卡类型
     *
     * @param context
     * @return
     */
    public static String checkSimType(Context context) {

        TelephonyManager telManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String operator = telManager.getSimOperator();

        if (operator != null) {

            if (operator.equals("46000") || operator.equals("46002") || operator.equals("46007")) {
                LogUtil.i("此卡属于(中国移动)");
                return "中国移动";

            } else if (operator.equals("46001") || operator.equals("46006")) {
                LogUtil.i("此卡属于(中国联通 )");
                return "中国联通";

            } else if (operator.equals("46003") || operator.equals("46005")|| operator.equals("46011")) {
                LogUtil.i("此卡属于(中国电信)");
                return "中国电信";

            }
        }

        LogUtil.i("无法识别手机卡运营商");
        return "无法识别手机卡";

    }


    private static String checkYD(String diquidYD) {
        int areaid = Integer.parseInt(diquidYD);
        String diquname = "";
        switch (areaid) {
            case 1: {
                diquname = "北京市";
                break;
            }
            case 2: {
                diquname = "天津市";
                break;
            }
            case 3: {
                diquname = "河北省";
                break;
            }
            case 4: {
                diquname = "山西省";
                break;
            }
            case 5: {
                diquname = "内蒙古自治区";
                break;
            }
            case 6: {
                diquname = "辽宁省";
                break;
            }
            case 7: {
                diquname = "吉林省";
                break;
            }
            case 8: {
                diquname = "黑龙江省";
                break;
            }
            case 9: {
                diquname = "上海市";
                break;
            }
            case 10: {
                diquname = "江苏省";
                break;
            }
            case 11: {
                diquname = "浙江省";
                break;
            }
            case 12: {
                diquname = "安徽省";
                break;
            }
            case 13: {
                diquname = "福建省";
                break;
            }
            case 14: {
                diquname = "江西省";
                break;
            }
            case 15: {
                diquname = "山东省";
                break;
            }
            case 16: {
                diquname = "河南省";
                break;
            }
            case 17: {
                diquname = "河北省";
                break;
            }
            case 18: {
                diquname = "湖南省";
                break;
            }
            case 19: {
                diquname = "广东省";
                break;
            }
            case 20: {
                diquname = "广西壮族自治区";
                break;
            }
            case 21: {
                diquname = "海南省";
                break;
            }
            case 22: {
                diquname = "四川省";
                break;
            }
            case 23: {
                diquname = "贵州省";
                break;
            }
            case 24: {
                diquname = "云南省";
                break;
            }
            case 25: {
                diquname = "西藏自治区";
                break;
            }
            case 26: {
                diquname = "陕西省";
                break;
            }
            case 27: {
                diquname = "甘肃省";
                break;
            }
            case 28: {
                diquname = "青海省";
                break;
            }
            case 29: {
                diquname = "宁夏自治区";
                break;
            }
            case 30: {
                diquname = "新疆维吾尔自治区";
                break;
            }
            case 31: {
                diquname = "重庆市";
                break;
            }
            default: {
                LogUtil.i("获取地区失败");
                diquname = "未知";
                break;
            }
        }
        LogUtil.i("移动地区" + diquname) ;
        return diquname;

    }

    private static String checkLT(String diquidLT) {
        int areaid = Integer.parseInt(diquidLT);
        String diquname = "";

        switch (areaid) {
            case 11: {
                diquname = "北京市";
                break;
            }
            case 13: {
                diquname = "天津市";
                break;
            }
            case 18: {
                diquname = "河北省";
                break;
            }
            case 19: {
                diquname = "山西省";
                break;
            }
            case 10: {
                diquname = "内蒙古自治区";
                break;
            }
            case 91: {
                diquname = "辽宁省";
                break;
            }
            case 90: {
                diquname = "吉林省";
                break;
            }
            case 97: {
                diquname = "黑龙江省";
                break;
            }
            case 31: {
                diquname = "上海市";
                break;
            }
            case 34: {
                diquname = "江苏省";
                break;
            }
            case 36: {
                diquname = "浙江省";
                break;
            }
            case 30: {
                diquname = "安徽省";
                break;
            }
            case 38: {
                diquname = "福建省";
                break;
            }
            case 75: {
                diquname = "江西省";
                break;
            }
            case 17: {
                diquname = "山东省";
                break;
            }
            case 76: {
                diquname = "河南省";
                break;
            }
            case 71: {
                diquname = "湖北省";
                break;
            }
            case 74: {
                diquname = "湖南省";
                break;
            }
            case 51: {
                diquname = "广东省";
                break;
            }
            case 59: {
                diquname = "广西壮族自治区";
                break;
            }
            case 50: {
                diquname = "海南省";
                break;
            }
            case 81: {
                diquname = "四川省";
                break;
            }
            case 85: {
                diquname = "贵州省";
                break;
            }
            case 86: {
                diquname = "云南省";
                break;
            }
            case 79: {
                diquname = "西藏自治区";
                break;
            }
            case 84: {
                diquname = "陕西省";
                break;
            }
            case 87: {
                diquname = "甘肃省";
                break;
            }
            case 70: {
                diquname = "青海省";
                break;
            }
            case 88: {
                diquname = "宁夏自治区";
                break;
            }
            case 89: {
                diquname = "新疆维吾尔自治区";
                break;
            }
            case 83: {
                diquname = "重庆市";
                break;
            }
            default: {
                LogUtil.i("获取地区失败");
                diquname = "未知";
                break;
            }
        }
        LogUtil.i("联通地区" + diquname) ;
        return diquname;

    }

    private static String checkDX(String diquidDX) {

        String id;
        if (diquidDX.substring(0, 1) == "0") {
            id = diquidDX.substring(1, 3);
        } else {
            id = diquidDX;
        }
        int areaid = Integer.parseInt(id);
        String diquname = "";
        switch (areaid) {
            case 10:
                diquname = "北京市";
                break;
            case 21:
                diquname = "上海市";
                break;
            case 22:
                diquname = "天津市";
                break;
            case 23:
                diquname = "重庆市";
                break;
            case 24:
                diquname = "辽宁省";
                break;
            case 25:
                diquname = "江苏省";
                break;
            case 27:
                diquname = "河北省";
                break;
            case 28:
                diquname = "四川省";
                break;
            case 29:
                diquname = "陕西省";
                break;
            case 20:
                diquname = "广东省";
                break;
            case 31:
                diquname = "河北省";
                break;
            case 32:
                diquname = "河北省";
                break;
            case 33:
                diquname = "河北省";
                break;
            case 34:
                diquname = "山西省";
                break;
            case 35:
                diquname = "山西省";
                break;
            case 37:
                diquname = "河南省";
                break;
            case 38:
                diquname = "河南省";
                break;
            case 39:
                diquname = "河南省";
                break;
            case 41:
                diquname = "辽宁省";
                break;
            case 42:
                diquname = "辽宁省";
                break;
            case 43:
                diquname = "吉林省";
                break;
            case 44:
                diquname = "吉林省";
                break;
            case 45:
                diquname = "黑龙江省";
                break;
            case 46:
                diquname = "黑龙江省";
                break;
            case 47:
                diquname = "内蒙古自治区";
                break;
            case 48:
                diquname = "内蒙古自治区";
                break;
            case 51:
                diquname = "江苏省";
                break;
            case 52:
                diquname = "江苏省";
                break;
            case 53:
                diquname = "山东省";
                break;
            case 54:
                diquname = "山东省";
                break;
            case 63:
                diquname = "山东省";
                break;
            case 55:
                diquname = "安徽省";
                break;
            case 56:
                diquname = "安徽省";
                break;
            case 57:
                diquname = "浙江省";
                break;
            case 58:
                diquname = "浙江省";
                break;
            case 59:
                diquname = "福建省";
                break;
            case 69:
                diquname = "云南省";
                break;
            case 71:
                diquname = "湖北省";
                break;
            case 72:
                diquname = "湖北省";
                break;
            case 73:
                diquname = "湖南省";
                break;
            case 74:
                diquname = "湖南省";
                break;
            case 75:
                diquname = "广东省";
                break;
            case 76:
                diquname = "广东省";
                break;
            case 66:
                diquname = "广东省";
                break;
            case 77:
                diquname = "广西壮族自治区";
                break;
            case 79:
                diquname = "江西省";
                break;
            case 70:
                diquname = "江西省";
                break;
            case 81:
                diquname = "四川省";
                break;
            case 82:
                diquname = "四川省";
                break;
            case 83:
                diquname = "四川省";
                break;
            case 85:
                diquname = "贵州省";
                break;
            case 87:
                diquname = "云南省";
                break;
            case 88:
                diquname = "云南省";
                break;
            case 891:
                diquname = "西藏自治区";
                break;
            case 892:
                diquname = "西藏自治区";
                break;
            case 893:
                diquname = "西藏自治区";
                break;
            case 894:
                diquname = "西藏自治区";
                break;
            case 895:
                diquname = "西藏自治区";
                break;
            case 896:
                diquname = "西藏自治区";
                break;
            case 897:
                diquname = "西藏自治区";
                break;
            case 898:
                diquname = "海南省";
                break;
            case 91:
                diquname = "陕西省";
                break;
            case 93:
                diquname = "甘肃省";
                break;
            case 94:
                diquname = "甘肃省";
                break;
            case 95:
                diquname = "宁夏自治区";
                break;
            case 97:
                diquname = "青海省";
                break;
            case 99:
                diquname = "新疆维吾尔自治区";
                break;
            case 90:
                diquname = "新疆维吾尔自治区";
                break;
            default: {
                LogUtil.i("电信地区：获取地区失败");
                diquname = "未知";
                break;
            }
        }

        return diquname;
    }


    /**
     * 返回用户手机运营商名称  * @param telephonyManager  * @return
     */
    public static String getProvidersName(String IMSI,String ICCID) {
        String ProvidersName = null;
        if (IMSI == null)
            return "unkwon";
        // IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。其中
        if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
            ProvidersName = "中国移动，" + checkYD(Integer.parseInt(ICCID.substring(8, 10)) + "");
        } else if (IMSI.startsWith("46001")) {
            ProvidersName ="中国联通，" + checkLT(Integer.parseInt(ICCID.substring(9, 11)) + "");
        } else if (IMSI.startsWith("46003")) {
            ProvidersName = "中国电信，" + checkDX(Integer.parseInt(ICCID.substring(9, 12)) + "");
        }
        return ProvidersName;

    }


}
