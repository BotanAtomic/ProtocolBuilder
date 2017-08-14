package com.ankamagames.dofus.network.types.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkType;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class MonsterBoosts extends Object implements INetworkType {

  public int id = 0;
  public int xpBoost = 0;
  public int dropBoost = 0;
  public static final int protocolId = 497;

  public void serialize(ICustomDataOutput param1) {
    if (this.id < 0) {
      throw new Error("Forbidden value (" + this.id + ") on element id.");
    }
    param1.writeVarInt(this.id);
    if (this.xpBoost < 0) {
      throw new Error("Forbidden value (" + this.xpBoost + ") on element xpBoost.");
    }
    param1.writeVarShort(this.xpBoost);
    if (this.dropBoost < 0) {
      throw new Error("Forbidden value (" + this.dropBoost + ") on element dropBoost.");
    }
    param1.writeVarShort(this.dropBoost);
  }

  public void deserialize(ICustomDataInput param1) {
    this.id = param1.readUTF();

    this.xpBoost = param1.readVarUhShort();
    if (this.xpBoost < 0) {
      throw new Error(
          "Forbidden value (" + this.xpBoost + ") on element of MonsterBoosts.xpBoost.");
    }

    this.dropBoost = param1.readVarUhShort();
    if (this.dropBoost < 0) {
      throw new Error(
          "Forbidden value (" + this.dropBoost + ") on element of MonsterBoosts.dropBoost.");
    }
  }
}
