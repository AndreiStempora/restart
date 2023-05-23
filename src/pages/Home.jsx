import { IonContent, IonHeader, IonPage, IonTitle, IonToolbar } from '@ionic/react';
import ExploreContainer from '../components/ExploreContainer';
import './Home.css';
// import 'restart-app';
// import { Plugins } from '@capacitor/core';
import {Filesystem, Directory} from "@capacitor/filesystem";
import {useEffect} from "react";


const Home = () => {
    // const { RestartApp } = Plugins;
    const readSecretFile = async () => {
        const contents = await Filesystem.readFile({
            path: 'secrets/texxt',
        });
        
        console.log('secrets:', contents);
    };
    
    useEffect(() => {
        (async () => {
        // console.log('restart FF', await RestartApp.wtf({ value: 'Hello22222' }));
            console.log("app will die")
        setTimeout(async () => {
            console.log("app died")
            await readSecretFile();
        }, 10000);
        })();
    }, []);
  
  return (
    <IonPage>
      <IonHeader>
        <IonToolbar>
          <IonTitle>Bla affa</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Blank</IonTitle>
          </IonToolbar>
        </IonHeader>
        <ExploreContainer />
      </IonContent>
    </IonPage>
  );
};

export default Home;
