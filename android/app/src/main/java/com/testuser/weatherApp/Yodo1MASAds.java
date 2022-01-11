package com.testuser.weatherApp;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.yodo1.mas.Yodo1Mas;
import com.yodo1.mas.error.Yodo1MasError;
import com.yodo1.mas.event.Yodo1MasAdEvent;
import com.yodo1.mas.helper.model.Yodo1MasAdBuildConfig;

public class Yodo1MASAds extends ReactContextBaseJavaModule {
    Yodo1MASAds(ReactApplicationContext context) {
        super(context);

    }


   
    @ReactMethod
    public void initMasSdk()
    {
          Yodo1MasAdBuildConfig config = new Yodo1MasAdBuildConfig.Builder().enableUserPrivacyDialog(true).build();
        Yodo1Mas.getInstance().setAdBuildConfig(config);
        //Call Delegate Function before Init Sdk:
        intiDelagates();
        Yodo1Mas.getInstance().init(Yodo1MASAds.this.getCurrentActivity(), "0Sf2oKrR4h", new Yodo1Mas.InitListener() {
            @Override
            public void onMasInitSuccessful() {
            }

            @Override
            public void onMasInitFailed(@NonNull Yodo1MasError error) {
            }
        });
       // showBannerAds();
    }

    @ReactMethod
    public void intiDelagates()
    {
        //Delegate for Banner
        Yodo1Mas.getInstance().setBannerListener(new Yodo1Mas.BannerListener() {
            @Override
            public void onAdOpened(@NonNull Yodo1MasAdEvent event) {

            }

            @Override
            public void onAdError(@NonNull Yodo1MasAdEvent event, @NonNull Yodo1MasError error) {

            }

            @Override
            public void onAdClosed(@NonNull Yodo1MasAdEvent event) {

            }
        });
        //Delegate for Interstitial
        Yodo1Mas.getInstance().setInterstitialListener(new Yodo1Mas.InterstitialListener() {
            @Override
            public void onAdOpened(@NonNull Yodo1MasAdEvent event) {
            }

            @Override
            public void onAdError(@NonNull Yodo1MasAdEvent event, @NonNull Yodo1MasError error) {

            }

            @Override
            public void onAdClosed(@NonNull Yodo1MasAdEvent event) {

            }
        });

        //Delegate for RewardedAds
        Yodo1Mas.getInstance().setRewardListener(new Yodo1Mas.RewardListener() {
            @Override
            public void onAdOpened(@NonNull Yodo1MasAdEvent event) {

            }

            @Override
            public void onAdvertRewardEarned(@NonNull Yodo1MasAdEvent event) {
                
            }

            @Override
            public void onAdError(@NonNull Yodo1MasAdEvent event, @NonNull Yodo1MasError error) {

            }

            @Override
            public void onAdClosed(@NonNull Yodo1MasAdEvent event) {

            }
        });
    }
    @ReactMethod
    public void giveRewardToUsers(int rewardAmount)
    {
        Yodo1Mas.getInstance().setRewardListener(new Yodo1Mas.RewardListener() {
            @Override
            public void onAdOpened(@NonNull Yodo1MasAdEvent event) {

            }

            @Override
            public void onAdvertRewardEarned(@NonNull Yodo1MasAdEvent event) {
                
            }

            @Override
            public void onAdError(@NonNull Yodo1MasAdEvent event, @NonNull Yodo1MasError error) {

            }

            @Override
            public void onAdClosed(@NonNull Yodo1MasAdEvent event) {

            }
        });

    }
    @ReactMethod
public void showBannerAds()
{
    int align = Yodo1Mas.BannerBottom | Yodo1Mas.BannerHorizontalCenter;
    Yodo1Mas.getInstance().showBannerAd(Yodo1MASAds.this.getCurrentActivity());
}

@ReactMethod
public void hideBannerAds()
{
    Yodo1Mas.getInstance().dismissBannerAd();
}

    @ReactMethod
public void showIntertstialAds()
{

    Yodo1Mas.getInstance().showInterstitialAd(Yodo1MASAds.this.getCurrentActivity());
}
    @ReactMethod
public void showRewardedAds()
{
    
    Yodo1Mas.getInstance().showRewardedAd(Yodo1MASAds.this.getCurrentActivity());
}

@Override
public String getName() {
    return "Yodo1MASAds";
}

}