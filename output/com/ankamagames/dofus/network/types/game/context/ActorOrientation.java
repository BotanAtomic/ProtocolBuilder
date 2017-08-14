package com.ankamagames.dofus.network.types.game.context;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class ActorOrientation extends Object implements INetworkType {

  public Number id = 0;
  public int direction = 1;
  public static final int protocolId = 353;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < -9.007199254740992E15 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeDouble(this.id);
    param1.writeByte(this.direction);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.direction = param1.readByte();
    if (this.direction < 0) {
      throw new Error(
          "Forbidden value ("
              + this.direction
              + ") on element of TreasureHuntStepFollowDirectionToPOI.direction.");
    }
  }
}
