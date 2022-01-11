import React, { Component } from 'react';
import { Text, View, StyleSheet, Image } from 'react-native';
import { NativeModules } from 'react-native';
const { Yodo1MASAds } = NativeModules;
export default class WeatherScreen extends Component {
  constructor() {
    super();
    this.state = {
      weather: '',
    };
  }

  getWeather = async () => {
    //change latitude and longitude
    Yodo1MASAds.initMasSdk()
    var url = 'https://fcc-weather-api.glitch.me/api/current?lat=35&lon=139';
    return fetch(url)
      .then(response => response.json())
      .then(responseJson => {
        Yodo1MASAds.showInterstitialAds();
        this.setState({
          weather: responseJson,
        });

      })
      .catch(error => {
        console.error(error);
      });
  };

  componentDidMount = () => {
    this.getWeather();
    Yodo1MASAds.initMasSdk()
  };

  render() {
    if (this.state.weather === '') {
      return (
        <View style={styles.container}>
          Yodo1MASAds.showInterstitialAds();
          Yodo1MASAds.showBannerAds();

        </View>
      );
    } else {
      return (
        <View style={styles.container}>
          Yodo1MASAds.initMasSdk()
          Yodo1MASAds.showBannerAds();
          Yodo1MASAds.showInterstitialAds();

          <View style={styles.subContainer}>
            <Text style={styles.title}>
              Weather Forecast
            </Text>
            <Image
              style={styles.cloudImage}
            //  source={require('./clouds.png')}
           />
            <View style={styles.textContainer}>
            <Text style={{ fontSize: 18}}>
              {this.state.weather.main.temp}&deg;C
            </Text>
            <Text style={{ fontSize: 20, margin:10}}>
              humidity : {this.state.weather.main.humidity}
            </Text>
            <Text style={{fontSize: 20}}>
              {this.state.weather.weather[0].description}
            </Text>
          </View>
          </View>    
        </View>
      );
    }
  }
}

const styles = StyleSheet.create({
  container: {
   flex:1
  },
  subContainer : { 
    flex: 1, 
    borderWidth: 1, 
    alignItems: 'center' 
    },
    title:{ 
      marginTop: 50, 
      fontSize: 30,
      fontWeight: '550' 
    },
    cloudImage :{ 
      width: 200, 
      height: 200, 
      marginTop: 30 
    },
    textContainer : { 
      flex: 1,
      alignItems: 'center', 
      flexDirection:'row', 
      marginTop:-150
    }
});

