(function() {
  var $searchOverlay = document.querySelector(".search-overlay");
  var $search = document.querySelector(".search");
  var $clone, offsetX, offsetY;

  $search.addEventListener("click", function() {
    var $original = this;
    $clone = this.cloneNode(true);

    $searchOverlay.classList.add("s--active");

    $clone.classList.add("s--cloned", "s--hidden");
    $searchOverlay.appendChild($clone);

    var triggerLayout = $searchOverlay.offsetTop;

    var originalRect = $original.getBoundingClientRect();
    var cloneRect = $clone.getBoundingClientRect();

    offsetX = originalRect.left - cloneRect.left;
    offsetY = originalRect.top - cloneRect.top;

    $clone.style.transform = "translate("+ offsetX +"px, "+ offsetY +"px)";
    $original.classList.add("s--hidden");
    $clone.classList.remove("s--hidden");

    var triggerLayout = $searchOverlay.offsetTop;

    $clone.classList.add("s--moving");

    $clone.setAttribute("style", "");

    $clone.addEventListener("transitionend", openAfterMove);
  });

  function openAfterMove() {
    $clone.classList.add("s--active");
    $clone.querySelector("input").focus();

    addCloseHandler($clone);
    $clone.removeEventListener("transitionend", openAfterMove);
  };
  
  function addCloseHandler($parent) {
    var $closeBtn = $parent.querySelector(".search__close");
    $closeBtn.addEventListener("click", closeHandler);
  };

  /* close handler functions */
  function closeHandler(e) {
    $clone.classList.remove("s--active");
    e.stopPropagation();
    
    var $cloneBg = $clone.querySelector(".search__bg");

    $cloneBg.addEventListener("transitionend", moveAfterClose);
  };
  
  function moveAfterClose(e) {
    e.stopPropagation(); // prevents from double transitionend even fire on parent $clone
    
    $clone.classList.add("s--moving");
    $clone.style.transform = "translate("+ offsetX +"px, "+ offsetY +"px)";
    $clone.addEventListener("transitionend", terminateSearch);
  };
  
  function terminateSearch(e) {
    $search.classList.remove("s--hidden");
    $clone.remove();
    $searchOverlay.classList.remove("s--active");
  };
}());
