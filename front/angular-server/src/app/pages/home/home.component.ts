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
    const menuItems = document.querySelectorAll('.menuItem');
    const messagesNotifications = document.querySelector(
      '#message-notifications'
    );
    const messages = document.querySelector('.messages');
    const message = (messages as HTMLDivElement).querySelectorAll('.message');
    const messageSearch = document.querySelector('#message-Search');

    const theme = document.querySelector('#theme');
    const themeModal = document.querySelector('.customizeTheme');
    const fontSize = document.querySelectorAll('.chooseSize span');
    var html = document.querySelector(':root');

    // Remove active class from all menu items
    const removeaActive = () => {
      menuItems.forEach((item) => item.classList.remove('active'));
    };

    // Thme change
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
    // Event listener for theme change
    themeModal?.addEventListener('click', closeThemeModal);
    
    theme?.addEventListener('click', openThemeModal);

    // Event listener for font size change
    const removeSizeSelector = () => {
      fontSize.forEach(size =>{
        size.classList.remove('active');
      })
    }

    // Change color

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

    // Add active class to menu item
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

    // Add active class to menu item
  }

  // Theme

  // const openThemeModal = () =>{
  //   (themeModal).style.display = 'grid';
  // }

  // theme.addEventListener('click', openThemeModal);
}
