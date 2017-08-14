package com.ankamagames.dofus.network.types.game.character;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class AbstractCharacterInformation extends Object implements INetworkType {

  public Number id = 0;
  public static final int protocolId = 400;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0 || this.id > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarLong(this.id);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();
  }
}
