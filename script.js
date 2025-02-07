const btn = document.querySelector('.btn');
const images = document.querySelectorAll('.img');
const image = document.querySelectorAll('.test')[0];
const container = document.querySelector('.container');
const secret = document.querySelector('.secret');

const originalImages = ['andrey.jpg', 'image2.jpg'];
const newImages = ['andrey2.jpg', 'images3.jpg'];

let isOriginal = true;

const img = document.createElement('img');
const test = async () => {
    try {
        const response = await fetch('https://drugdillerandrew-production.up.railway.app/photo?number=1');
        const data = await response.json();
        console.log(data)
        image.src = data.imageUrl;
    }
    catch (error) {
        console.log(error);
    }
}



secret.addEventListener('click', () => {
    container.classList.toggle('hide');
    setTimeout(() =>  {
        container.classList.remove('hide');
    },2000)
});

btn.addEventListener('click', (e) => {

    test()

    images.forEach(img => img.classList.add('hidden'));

    setTimeout(() => {
        if (isOriginal) {
            images[0].src = newImages[0];
            images[1].src = newImages[1];
        } else {
            images[0].src = originalImages[0];
            images[1].src = originalImages[1];
        }

        isOriginal = !isOriginal;

        images.forEach(img => img.classList.remove('hidden'));
    }, 500);
});