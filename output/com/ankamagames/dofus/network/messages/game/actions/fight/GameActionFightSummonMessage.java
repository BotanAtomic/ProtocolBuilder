package com.ankamagames.dofus.network.messages.game.actions.fight;

import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.GameFightFighterInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameActionFightSummonMessage extends AbstractGameActionMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<GameFightFighterInformations> summons;
  private FuncTree _summonstree;
  public static final int protocolId = 5825;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Error("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Error("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeDouble(this.sourceId);

    param1.writeShort(this.summons.length);
    int _loc2_ = 0;
    while (_loc2_ < this.summons.length) {
      param1.writeShort(((GameFightFighterInformations) (this.summons[_loc2_])).getTypeId());
      ((GameFightFighterInformations) this.summons[_loc2_]).serialize(param1);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    int _loc4_ = 0;
    GameFightFighterInformations _loc5_ = null;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Error(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Error(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readUnsignedShort();
      _loc5_ = ProtocolTypeManager.getInstance(GameFightFighterInformations, _loc4_);
      _loc5_.deserialize(param1);
      this.summons.push(_loc5_);
      _loc3_++;
    }
  }
}
