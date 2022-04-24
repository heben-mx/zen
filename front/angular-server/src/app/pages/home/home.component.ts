import { createMayBeForwardRefExpression } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { isEmpty } from '@firebase/util';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  title = 'Zen';

  constructor() { }

  ngOnInit() {
    
    // these are the global variables that are used in the html

    // this is the variable that is used to collapse the notifications
    const menuItems = document.querySelectorAll('.menuItem');
    const messagesNotifications = document.querySelector(
      '#message-notifications'
    );
    // this is the variable that is used to show the messages
    const messages = document.querySelector('.messages');
    const message = (messages as HTMLDivElement).querySelectorAll('.message');
    const messageSearch = document.querySelector('#message-Search');

    // These are the variables that are used to change the theme settings
    const theme = document.querySelector('#theme');
    const themeModal = document.querySelector('.customizeTheme');
    var html = document.querySelector('html');
    const htmlSettings = document.querySelectorAll('html');
    // this is the variable that is used to change the font size
    const fontSize = document.querySelectorAll('.chooseSize span');
    // this is the variable that is used to change the color of the theme
    const colorPalette = document.querySelectorAll('.chooseColor span');

    const Bg1 = document.querySelector('.bg1')
    const Bg2 = document.querySelector('.bg2')
    const Bg3 = document.querySelector('.bg3')

    // Remove active class from all menu items
    const removeaActive = () => {
      menuItems.forEach((item) => item.classList.remove('active'));
    };

    // Theme change

    // open modal
    const openThemeModal = () => {
      (themeModal as HTMLDivElement).style.display = 'grid';
    };

    // close modal
    const closeThemeModal = (e: any) => {
      if (e.target.classList.contains('customizeTheme')) {
        (themeModal as HTMLDivElement).style.display = 'none';
      }
    };
    // Event listener to close modal
    themeModal?.addEventListener('click', closeThemeModal);

    // Event listener to open modal
    theme?.addEventListener('click', openThemeModal);

    // font size change remove active class 
    const removeSizeSelector = () => {
      fontSize.forEach(size => {
        size.classList.remove('active');
      })
    }

    // color change remove active class
    const changeActiveColorClass = () => {
      colorPalette.forEach(color => {
        color.classList.remove('active');
      })
    }

    // Function to change the color of the theme
    colorPalette.forEach((color) => {

      color.addEventListener('click', () => {
        let colorPalette: any = color as HTMLSpanElement ;
        changeActiveColorClass();
        color.classList.toggle('active');
        
        
        if (color.classList.contains('color1')) {
          colorPalette = '216';
          
          
        } else if (color.classList.contains('color2')) {
          colorPalette = '52';
          
        } else if (color.classList.contains('color3')) {
          colorPalette = '352';
          
        } else if (color.classList.contains('color4')) {
          colorPalette = '152';

        } else if (color.classList.contains('color5')) {
          colorPalette = '252';
          
        }
        // this is the variable that is used to change the color of all the elements with the var --color-primary
        htmlSettings.forEach(html => {
          html.style.setProperty('--color-primary', 'hsl(' + colorPalette + ', 74%, 36%)');
        })


      });
    });


    // Fuction to change the font size of the theme

    fontSize.forEach((size) => {


      size.addEventListener('click', () => {
        removeSizeSelector();
        let fontSize: any = size;
        size.classList.toggle('active');

        if (size.classList.contains('fontSize1')) {
          fontSize = '10px';
          (html as HTMLElement).style.setProperty(
            '--sticky-top-left',
            '5.4rem'
          );
          (html as HTMLElement).style.setProperty(
            '--sticky-top-right',
            '5.4rem'
          );

        } else if (size.classList.contains('fontSize2')) {
          fontSize = '12px';
          (html as HTMLElement).style.setProperty(
            '--sticky-top-left',
            '5.4rem'
          );
          (html as HTMLElement).style.setProperty(
            '--sticky-top-right',
            '-7rem'
          );
        } else if (size.classList.contains('fontSize3')) {
          fontSize = '16px';
          (html as HTMLElement).style.setProperty(
            '--sticky-top-left',
            '-2rem'
          );
          (html as HTMLElement).style.setProperty(
            '--sticky-top-right',
            '-17rem'
          );
        } else if (size.classList.contains('fontSize4')) {
          fontSize = '18px';
          (html as HTMLElement).style.setProperty(
            '--sticky-top-left',
            '-5rem'
          );
          (html as HTMLElement).style.setProperty(
            '--sticky-top-right',
            '-25rem'
          );
        } else if (size.classList.contains('fontSize5')) {
          fontSize = '20px';
          (html as HTMLElement).style.setProperty(
            '--sticky-top-left',
            '-10rem'
          );
          (html as HTMLElement).style.setProperty(
            '--sticky-top-right',
            '-33rem'
          )
        }
        (html as HTMLElement).style.fontSize = fontSize;
      });



    });




    let darkColorLightness: string = '17%';
    let lightColorLightness: string = '95%';
    let whiteColorLightness: string = '100%';

    const changeBG = () => {
      htmlSettings.forEach(html => {
        html.style.setProperty('--light-color-lightness', lightColorLightness);
        html.style.setProperty('--dark-color-lightness', darkColorLightness);
        html.style.setProperty('--white-color-lightness', whiteColorLightness);
      })
    }

    Bg1?.addEventListener('click', () => {
      Bg1.classList.add('active');
      Bg2?.classList.remove('active');
      Bg3?.classList.remove('active');

      window.location.reload();
    })


    Bg2?.addEventListener('click', () => {
      darkColorLightness = '95%';
      whiteColorLightness = '20%';
      lightColorLightness = '15%';

      Bg2.classList.add('active');

      Bg1?.classList.remove('active');
      Bg3?.classList.remove('active');

      changeBG();
    });

    Bg3?.addEventListener('click', () => {
      darkColorLightness = '95';
      whiteColorLightness = '10';
      lightColorLightness = '0%';

      Bg3.classList.add('active');

      Bg1?.classList.remove('active');
      Bg2?.classList.remove('active');

      changeBG();
    });






    // Search for messages

    // const searchMessage = () =>{
    //   const val = (messageSearch as HTMLInputElement).innerHTML.toLowerCase();
    //   console.log(val);
    //   message.forEach(chat =>{
    //     let name = chat.querySelectorAll('h5').textContent.toLowerCase();
    //     if(name.indexOf(val) != -1){
    //       (chat as HTMLDivElement).style.display = 'flex';
    //     }else{
    //       (chat as HTMLDivElement).style.display = 'none';
    //     }

    //   })

    // }


    //   Add box-shadow to menu item
    (messagesNotifications as HTMLDivElement).addEventListener('click', () => {
      (messages as HTMLDivElement).style.boxShadow =
        '0 0 1rem var(--color-primary)';
      if (
        (messages as HTMLDivElement).style.boxShadow ==
        '0 0 1rem var(--color-primary)'
      ) {
        const messagesOff = () => {
          (messages as HTMLDivElement).style.boxShadow = 'none';
        };
        // timeout to remove box-shadow
        setTimeout(messagesOff, 1500);
        (messages as HTMLDivElement).style.transition = 'box-shadow 0.3s ease';

        // remove addeventlistener
      }
    });


    // Function to collapse and expand the notification menu
    menuItems.forEach((item) => {
      item.addEventListener('click', () => {
        removeaActive();
        item.classList.add('active');
        //  if one of the items is not notifications, set display element to none
        if (item.id != 'notifications') {
          const notificationsOff = () => {
            (
              document.querySelector('.notificationsPopup') as HTMLDivElement
            ).style.display = 'none';
          };
          notificationsOff();
          //  else display element to block
        } else if (
          (document.querySelector('.notificationsPopup') as HTMLDivElement)
            .style.display == 'block'
        ) {
          // And if the user clicks again, close the popup element
          const notificationsOff = () => {
            (
              document.querySelector('.notificationsPopup') as HTMLDivElement
            ).style.display = 'none';
          };
          notificationsOff();
          removeaActive();
        } else {
          const notificationsOn = () => {
            (
              document.querySelector('.notificationsPopup') as HTMLDivElement
            ).style.display = 'block';
          };
          notificationsOn();
          (
            document.querySelector('.notificationCount') as HTMLDivElement
          ).style.display = 'none';
        }
      });
    });

  }


}
