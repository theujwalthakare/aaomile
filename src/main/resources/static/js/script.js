document.addEventListener("DOMContentLoaded", () => {
    const scrollContainer = document.querySelector(".scroll-container");
    const slideLeft = document.querySelector(".slide-left");
    const slideRight = document.querySelector(".slide-right");

    // Slide left
    slideLeft.addEventListener("click", () => {
        scrollContainer.scrollBy({ left: -300, behavior: "smooth" });
    });

    // Slide right
    slideRight.addEventListener("click", () => {
        scrollContainer.scrollBy({ left: 300, behavior: "smooth" });
    });
});
