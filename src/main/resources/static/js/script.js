document.addEventListener('DOMContentLoaded', function() {
    const scrollContainer = document.querySelector('.scroll-container');
    scrollContainer.classList.add('no-select');
    // Use requestAnimationFrame for smooth scrolling
    let ticking = false;
    let isMouseDown = false;
    let startX;
    let scrollLeft;
    let scrollInterval;
    const scrollSpeed = 5;
    
    // Optimize infinite scroll by limiting clones
    function setupInfiniteScroll() {
        const cards = [...scrollContainer.children];
        const containerWidth = scrollContainer.clientWidth;
        let totalWidth = 0;
        const neededClones = [];

        // Only clone enough cards to fill twice the container width
        for (const card of cards) {
            totalWidth += card.offsetWidth;
            if (totalWidth <= containerWidth * 2) {
                neededClones.push(card.cloneNode(true));
            } else {
                break;
            }
        }

        // Append optimized number of clones
        neededClones.forEach(clone => scrollContainer.appendChild(clone));
    }

    // Debounce the scroll handling
    function debounce(func, wait) {
        let timeout;
        return function executedFunction(...args) {
            const later = () => {
                clearTimeout(timeout);
                func(...args);
            };
            clearTimeout(timeout);
            timeout = setTimeout(later, wait);
        };
    }

    // Optimize mousemove handler using requestAnimationFrame
    function updateScroll(e) {
        if (!isMouseDown) return;
        
        if (!ticking) {
            requestAnimationFrame(() => {
                const x = e.pageX - scrollContainer.offsetLeft;
                const walk = (x - startX) * 1.5;
                scrollContainer.scrollLeft = scrollLeft - walk;
                ticking = false;
            });
            ticking = true;
        }
    }

    // Use passive event listeners where possible
    scrollContainer.addEventListener('mousedown', (e) => {
        isMouseDown = true;
        scrollContainer.style.cursor = 'grabbing';
        startX = e.pageX - scrollContainer.offsetLeft;
        scrollLeft = scrollContainer.scrollLeft;
    }, { passive: true });

    scrollContainer.addEventListener('mouseleave', () => {
        isMouseDown = false;
        scrollContainer.style.cursor = 'grab';
    }, { passive: true });

    scrollContainer.addEventListener('mouseup', () => {
        isMouseDown = false;
        scrollContainer.style.cursor = 'grab';
    }, { passive: true });

    // Optimize hover scrolling
    const containerRect = scrollContainer.getBoundingClientRect();
    const hoverWidth = 40;
    let lastScrollTime = 0;

    function smoothScroll(direction) {
        const now = performance.now();
        if (now - lastScrollTime > 16) { // Limit to ~60fps
            scrollContainer.scrollLeft += direction * scrollSpeed;
            lastScrollTime = now;
        }
    }

    const handleHoverScroll = debounce((e) => {
        const x = e.clientX - containerRect.left;
        clearInterval(scrollInterval);
        
        if (x < hoverWidth) {
            scrollInterval = setInterval(() => smoothScroll(-1), 16);
        } else if (x > containerRect.width - hoverWidth) {
            scrollInterval = setInterval(() => smoothScroll(1), 16);
        }
    }, 16);

    // Use more efficient event handling
    const mousemoveHandler = (e) => {
        e.preventDefault();
        updateScroll(e);
        handleHoverScroll(e);
    };

    // Add optimized event listeners
    scrollContainer.addEventListener('mousemove', mousemoveHandler, { passive: false });
    
    // Cleanup function to prevent memory leaks
    function cleanup() {
        clearInterval(scrollInterval);
        scrollContainer.removeEventListener('mousemove', mousemoveHandler);
    }

    // Initialize
    setupInfiniteScroll();
    
    // Clean up on page unload
    window.addEventListener('unload', cleanup, { passive: true });
});
