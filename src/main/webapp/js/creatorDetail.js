const root = document.documentElement;
const changeBtn = document.getElementById("changeBtn");
let mode = false;

let whiteColor = getComputedStyle(root).getPropertyValue("--white");
let blackColor = getComputedStyle(root).getPropertyValue("--black");

changeBtn.addEventListener("click", (e) => changeColor());

function changeColor() {
  mode = !mode;
  if (mode) {
    root.style.setProperty("--white", blackColor);
    root.style.setProperty("--black", whiteColor);
    changeBtn.style='color:black'
  } else {
    root.style.setProperty("--white", whiteColor);
    root.style.setProperty("--black", blackColor);
    changeBtn.style='color:white'
  }
}

const slideTL = gsap.timeline();
const maskTL = gsap.timeline();
const mainTL = gsap.timeline({
  repeat: -1,
  onRepeat: () => {
    gsap.set("#texttwo", { opacity: 0 });
    gsap.set("#bar", { scaleY: 0.1 });
    gsap.set("#textone h1", { opacity: 1 });
  }
});

gsap.set("#texttwo", { opacity: 0 });
gsap.set("#bar", { scaleY: 0.1 });

slideTL
  .to("#bar", 1, {
    y: 225,
    scaleY: 1,
    ease: "back.out"
  })
  .to("#slidebar", 1.5, {
    x: 600,
    delay: 0.5,
    ease: "back.inOut(0.8)"
  })
  .to("#slidebar", 1.5, {
    x: 0,
    delay: 0.5,
    ease: "back.inOut(0.8)"
  })
  .to("#slidebar", 1.5, {
    x: 600,
    delay: 0.5,
    ease: "back.inOut(0.8)"
  })
  .to("#bar", 1, {
    y: 500,
    scaleY: 0.1,
    ease: "back.in"
  });

maskTL
  .to("#textone", 1.5, {
    ease: "back.inOut(0.8)",
    "clip-path": "polygon(0 0, 91% 0, 81% 100%, 0% 100%)",
    onComplete: () => {
      gsap.set("#texttwo", { opacity: 1 });
    }
  })
  .to("#textone", 1.5, {
    delay: 0.5,
    ease: "back.inOut(0.8)",
    "clip-path": "polygon(0 0, 18% 0, 8% 100%, 0% 100%)",
    onComplete: () => {
      gsap.set("#textone h1", { opacity: 0 });
    }
  })
  .to("#textone", 1.5, {
    delay: 0.5,
    ease: "back.inOut(0.8)",
    "clip-path": "polygon(0 0, 91% 0, 81% 100%, 0% 100%)"
  });

mainTL.add(slideTL).add(maskTL, 1.5);
