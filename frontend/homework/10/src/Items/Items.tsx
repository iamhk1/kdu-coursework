import "./Items.scss"
interface allItem{
    itemsProp: {
        allItems: string[];
        set: React.Dispatch<React.SetStateAction<string[]>>;
        allSearchItems:string[],
        searchItems:React.Dispatch<React.SetStateAction<string[]>>;
      };

}
export  function Items({itemsProp}:allItem) {
    function deleteEntry(index:number)
    {
        const updatedItems = [...itemsProp.allItems];
        updatedItems.splice(index, 1);
        itemsProp.set(updatedItems);   
    }
  return (
    <div className="allItems">
      <h2>Items</h2>
      <div className="Items">
      {
        itemsProp.allSearchItems.length > 0 &&
        <div>
          {
            itemsProp.allSearchItems.map((item, index) => (
              <div className="each-item" key={index}>
              <p>{item}</p>
              <p key={index + "-image"}>
              <img
                onClick={() => deleteEntry(index)}
                src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAMAAABC4vDmAAAARVBMVEX////mABPlAAD/+/v+7/DqLzTqLTLrRknrQUX+8fHrPUH+9PT95eb/+PjqOj7rP0PvZGfoExrpKC3qNTnrS07oHCLpIigoV9eMAAAD40lEQVR4nM1c25bCIAy0BavVel/9/0/dUnW3F5ISCunMa46STgvJQMhm00NztZtVUF8bymS35d5o+vKF2Zdbgo7mVhakMSdaMory5uWqrsqiKMqDOlfm0A1c1VNT83Sm1vhQ5so+PgM/J1zZ+9vUGs+qXJnz38D3ER3N62tyXilyZc+9gV8DrmzPJ/cG1bgyj8HArx4dzb1vao0XJa7sZTTw/Y+r+jk0tcatCldmOxn4+ZmDTTU2tca9Z4KmRr33DFx1XNnb1OSM2bkyHjLagW/tp9NMKFTiysfT+9NpNle/yXF1yunTyctTN/CVdLg17jJyVe/IYd0rmk6BfyKPuXw6MoN2H7M90Fxl8upI83T4LJHDZVWBK4an/2DSD0AKXDE89cOuob2qknvF8DRMUCz9BneJV4YTzdM4lTMXmqukK0NNr0/TpNfSpKbkiuHJJw8MvYpWyTIZS/PkF1IMsamUF/fgxEcS8RMZoh6b+dElAVeRk0kwXeWIXnZqeg4uVamGDrHbmY8jMATIsSiUBQcBGZhAFhL0A9IKORanR0GJhQxMchQa8Bmu4lTqWHOKeXJgkvoYlcok3BJxMpPWy5BMmjBcSVWqX3OKeXKw9OPJuOJIF3+giR4wIeUONTNlgrlieLpEJR7c4hLI1Sn9krd8Gc4RHJYGrDxhdFloz5VwcEnQjFcMT0tTs+h0MWsSG5lYZ073OZVK/r2RaU45IlSqWHPKIZZr2QVkNwj9MnxcMTzRL1wO0WertoEjmOCKW13BKpVZbtPy5MBw1Q8aXGDKcFgQFF4XhvAIr+YTkTW25OdSNvUN+c4rXqVyCXQ2n2ZkQEItJQMjBH5+VjkOc2DoSKqlZKBVKuWTXHPKQXO1Fk8O9CTz+aRV4kAvR1Of9IpB6IV77FO85pSDDnFDn3QLjOhkYOCTcikWnTb13p160RqdYH590i5Zc6BT8bdPKTSnHLSaKJIeXMpgyBDchudVeAJ1CvH1IX7oiEsC4uKJGGYQAzJi6oKY5NHnnD6v4o5gpEAUDogSC1GMIsp2xA0OxK0gxE0zxO1FxI1YxC3rFJv7cwVlUiAegyAeGAmP1phHSHe0hngIiXhci3iwjVgCgFgsgVhWgliAg1iqhFjUhVj+lrtQMOb+IGJJJWLxKWKZLmJBM2LpN2KRPOJ1AsSLF4hXVBAv8yBee0K8IIZ4lQ7x0iHi9UzEi6yIV34RLkePJxPiNXLVrcrAQIbYmgCxiQNiuwvExiCMllqvhQpksxnItjyQDYwwWz1hNsXCbB+G2WgNsyUdZvM+zDaHmA0hMVtnYjYZde1YVYqdphi1Y/0FTwg+VkGFUTkAAAAASUVORK5CYII="
                alt=""
              />
            </p>
          </div>
        ))
          }
        </div>
      }
      <div className="Items">
        {
      itemsProp.allSearchItems.length === 0 &&
      <div>
      {
        itemsProp.allItems.map((item, index) => (
        <div className="each-item" key={index}>
        <p>{item}</p>
        <p key={index + "-image"}>
        <img onClick={() => deleteEntry(index)}src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAJQAAACUCAMAAABC4vDmAAAARVBMVEX////mABPlAAD/+/v+7/DqLzTqLTLrRknrQUX+8fHrPUH+9PT95eb/+PjqOj7rP0PvZGfoExrpKC3qNTnrS07oHCLpIigoV9eMAAAD40lEQVR4nM1c25bCIAy0BavVel/9/0/dUnW3F5ISCunMa46STgvJQMhm00NztZtVUF8bymS35d5o+vKF2Zdbgo7mVhakMSdaMory5uWqrsqiKMqDOlfm0A1c1VNT83Sm1vhQ5so+PgM/J1zZ+9vUGs+qXJnz38D3ER3N62tyXilyZc+9gV8DrmzPJ/cG1bgyj8HArx4dzb1vao0XJa7sZTTw/Y+r+jk0tcatCldmOxn4+ZmDTTU2tca9Z4KmRr33DFx1XNnb1OSM2bkyHjLagW/tp9NMKFTiysfT+9NpNle/yXF1yunTyctTN/CVdLg17jJyVe/IYd0rmk6BfyKPuXw6MoN2H7M90Fxl8upI83T4LJHDZVWBK4an/2DSD0AKXDE89cOuob2qknvF8DRMUCz9BneJV4YTzdM4lTMXmqukK0NNr0/TpNfSpKbkiuHJJw8MvYpWyTIZS/PkF1IMsamUF/fgxEcS8RMZoh6b+dElAVeRk0kwXeWIXnZqeg4uVamGDrHbmY8jMATIsSiUBQcBGZhAFhL0A9IKORanR0GJhQxMchQa8Bmu4lTqWHOKeXJgkvoYlcok3BJxMpPWy5BMmjBcSVWqX3OKeXKw9OPJuOJIF3+giR4wIeUONTNlgrlieLpEJR7c4hLI1Sn9krd8Gc4RHJYGrDxhdFloz5VwcEnQjFcMT0tTs+h0MWsSG5lYZ073OZVK/r2RaU45IlSqWHPKIZZr2QVkNwj9MnxcMTzRL1wO0WertoEjmOCKW13BKpVZbtPy5MBw1Q8aXGDKcFgQFF4XhvAIr+YTkTW25OdSNvUN+c4rXqVyCXQ2n2ZkQEItJQMjBH5+VjkOc2DoSKqlZKBVKuWTXHPKQXO1Fk8O9CTz+aRV4kAvR1Of9IpB6IV77FO85pSDDnFDn3QLjOhkYOCTcikWnTb13p160RqdYH590i5Zc6BT8bdPKTSnHLSaKJIeXMpgyBDchudVeAJ1CvH1IX7oiEsC4uKJGGYQAzJi6oKY5NHnnD6v4o5gpEAUDogSC1GMIsp2xA0OxK0gxE0zxO1FxI1YxC3rFJv7cwVlUiAegyAeGAmP1phHSHe0hngIiXhci3iwjVgCgFgsgVhWgliAg1iqhFjUhVj+lrtQMOb+IGJJJWLxKWKZLmJBM2LpN2KRPOJ1AsSLF4hXVBAv8yBee0K8IIZ4lQ7x0iHi9UzEi6yIV34RLkePJxPiNXLVrcrAQIbYmgCxiQNiuwvExiCMllqvhQpksxnItjyQDYwwWz1hNsXCbB+G2WgNsyUdZvM+zDaHmA0hMVtnYjYZde1YVYqdphi1Y/0FTwg+VkGFUTkAAAAASUVORK5CYII="alt=""/>
        </p>
      </div>
      ))
      }
      </div>
    }
  </div>

      </div>
    </div>
  )
}
