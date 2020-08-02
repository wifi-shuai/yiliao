package com.yiliao.health.service;


import com.yiliao.health.bean.Health;
import org.springframework.stereotype.Service;

/**
 * ClassName:HealthService
 * Package:com.yiliao.health.service
 * Description:
 *
 * @Date:2020/5/6 15:44
 * @Author:liangshuai@shuaige.com
 */
@Service
public class HealthService {

    public String showHealth(Health health, String username) {
        double BMI1 = health.getWeight();
        double BMI = BMI1 / (Math.pow(health.getHeight() / 100, 2.0));


        String h = "您好，亲爱的" + username;
//        if(health.getSex()=='男'){
//            h+="先生，";
//        }else if(health.getSex()=='女'){
//            h+="女士，";
//        }else{
//            h+="您的输入不符合规范，请合理输入。";
//        }


        if (BMI <= 18.5) {
            h += "您的体质偏轻，日常生活中可适当增加饮食。";
        } else if (BMI > 18.5 && BMI <= 23.9) {
            h += "您的体质正常，请继续维持，合理饮食。";
        } else if (BMI > 23.9 && BMI <= 28.0) {
            h += "您的体质超重，请适当多做运动，均衡饮食，多吃蔬菜水果。";
        } else if (BMI >= 28.0 && BMI <= 32.0) {
            h += "您的体质肥胖，请适当控制饮食，运动是最好的减肥办法，每天保证15~20分钟的快跑和有氧运动。";
        } else if (BMI > 32.0) {
            h += "您的体质非常肥胖，请控制饮食，不要暴饮暴食，加强体育锻炼，必要时可去医院咨询医生。";
        }

        if (health.getsBp() >= 90 && health.getsBp() <= 139 &&
                health.getdBp() >= 60 && health.getdBp() <= 89) {
            h += "您的血压正常，请继续合理饮食。";
        } else if (health.getsBp() >= 140 && health.getsBp() <= 159 &&
                health.getdBp() >= 90 && health.getdBp() <= 99) {
            h += "您的血压为轻度高血压，多注意休息，避免重体力劳动以及情绪激动，必要时可适量服用降压药。";
        } else if (health.getsBp() >= 180 && health.getdBp() >= 110) {
            h += "您的血压为重度高血压，建议及时药物降压治疗，控制血压水平。";
        } else if (health.getsBp() >= 140 && health.getdBp() < 90) {
            h += "您的血压为单纯收缩性高血压，注意生活方式的干预，比如低盐饮食、低脂饮食，坚持运动，保证睡眠，保持心情的舒畅，多吃新鲜蔬菜水果。";
        } else if (health.getsBp() < 90 && health.getdBp() < 60) {
            h += "您的血压为低血压，血压低的患者首先的做的就是加强自身的营养饮食，多摄入充足的营养食物。平时多熬汤水喝，可以加入桂圆、大枣、阿胶等补品，具有养心益血之功效。此外，可以适量增加盐分，多喝水等。";
        }

        if (health.getVision() >= 1.0 && health.getVision() <= 2.0) {
            h += "一般来说，人的正常视力范围是1.0，您的视力处于正常范围内，请不要沾沾自喜，要时刻注意用眼，多做眼保健操，给眼睛充分的休息时间，少看手机、电脑等电子产品。";
        } else if (health.getVision() >= 0.1 && health.getVision() < 1.0) {
            h += "一般来说，人的正常视力范围是1.0，您的视力目前处于近视状态，在视力下降比较明显的情况下，要及早的到医院验光并配戴眼镜，这样能够提高矫正视力，维持清晰的视觉质量。要保持合理正确的用眼习惯，尽量控制使用电脑、手机等电子产品的时间，这样能够减缓近视发展的速度，尤其是儿童或者青少年。对于高度近视，一般是指600度以上的近视，需要注意避免剧烈的运动，减少出现严重并发症的机会，另外要定期的做眼底检查，及早发现问题，及早干预，避免形成严重并发症以后对视力造成非常大的影响。";
        }
        return h;
    }
}
