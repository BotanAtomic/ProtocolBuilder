package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameFightSynchronizeMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<GameFightFighterInformations> fighters;
  private FuncTree _fighterstree;
  public static final int protocolId = 5921;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.fighters.length);
    int _loc2_ = 0;
    while (_loc2_ < this.fighters.length) {
      param1.writeShort(((GameFightFighterInformations) (this.fighters[_loc2_])).getTypeId());
      ((GameFightFighterInformations) this.fighters[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    GameFightFighterInformations _loc5_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(GameFightFighterInformations, _loc4_);
      _loc5_.deserialize(param1);
      this.fighters.push(_loc5_);
      _loc3_++;
    }
  }
}
