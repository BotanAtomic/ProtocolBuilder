package com.ankamagames.dofus.network.messages.game.context.roleplay;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterLightInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class MapRunningFightDetailsMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int fightId = 0;
  public Vector<GameFightFighterLightInformations> attackers;
  public Vector<GameFightFighterLightInformations> defenders;
  private FuncTree _attackerstree;
  private FuncTree _defenderstree;
  public static final int protocolId = 5751;

  public void serialize(ICustomDataOutput param1) {
    if (this.fightId < 0) {
      throw new Exception("Forbidden value (" + this.fightId + ") on element fightId.");
    }
    param1.writeInt(this.fightId);
    param1.writeShort(this.attackers.length);
    int _loc2_ = 0;
    while (_loc2_ < this.attackers.length) {
      param1.writeShort(((GameFightFighterLightInformations) (this.attackers[_loc2_])).getTypeId());
      ((GameFightFighterLightInformations) this.attackers[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.defenders.length);
    int _loc3_ = 0;
    while (_loc3_ < this.defenders.length) {
      param1.writeShort(((GameFightFighterLightInformations) (this.defenders[_loc3_])).getTypeId());
      ((GameFightFighterLightInformations) this.defenders[_loc3_]).serialize(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    GameFightFighterLightInformations _loc7_ = null;
    int _loc8_ = 0;
    GameFightFighterLightInformations _loc9_ = null;
    this.fightId = param1.readInt();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readUnsignedShort();
      _loc7_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations, _loc6_);
      _loc7_.deserialize(param1);
      this.attackers.push(_loc7_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc8_ = param1.readUnsignedShort();
      _loc9_ = ProtocolTypeManager.getInstance(GameFightFighterLightInformations, _loc8_);
      _loc9_.deserialize(param1);
      this.defenders.push(_loc9_);
      _loc5_++;
    }
  }
}
