const btn = document.querySelector('.btn');
const image = document.querySelector('.image');
const photoContainer = document.querySelector('.photo');

const fetchNewPhoto = async () => {
    try {
        const response = await fetch('https://drugdillerandrew-production.up.railway.app/photo?number=1');
        const data = await response.json();
        return data.imageUrl;
    } catch (error) {
        console.error(error);
    }
};


btn.addEventListener('click', async () => {
    const newImageUrl = await fetchNewPhoto();
    if (newImageUrl) {
        image.classList.remove('loaded');
        photoContainer.classList.remove('visible');
        setTimeout(() => {
            image.src = newImageUrl;
            photoContainer.style.display = 'block';


            setTimeout(() => {
                image.classList.add('loaded');
                photoContainer.classList.add('visible');
            }, 400);
        }, 500);
    } else {
        console.log('Не удалось загрузить новое фото');
    }
});