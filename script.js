const btn = document.querySelector('.btn');
const images = document.querySelectorAll('.img');

const originalImages = ['andrey.jpg', 'image2.jpg'];
const newImages = ['andrey2.jpg', 'images3.jpg'];

let isOriginal = true;

btn.addEventListener('click', (e) => {

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