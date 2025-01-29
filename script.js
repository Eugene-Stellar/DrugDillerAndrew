const btn = document.querySelector('.btn')
const images = document.querySelectorAll('.img')

btn.addEventListener('click', (e) => {
    images.forEach(img => img.classList.add('hidden'));

    setTimeout(() => {
        images[0].src = 'andrey2.jpg';

        images[1].src = 'images3.jpg';

        images.forEach(img => img.classList.remove('hidden'));
    }, 500);
});