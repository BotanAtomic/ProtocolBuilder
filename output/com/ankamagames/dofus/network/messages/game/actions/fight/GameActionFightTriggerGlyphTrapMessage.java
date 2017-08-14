package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.dofus.network.messages.game.actions.AbstractGameActionMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightTriggerGlyphTrapMessage extends AbstractGameActionMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int markId = 0;
  public Number triggeringCharacterId = 0;
  public int triggeredSpellId = 0;
  public static final int protocolId = 5741;

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

    param1.writeShort(this.markId);
    if (this.triggeringCharacterId < -9.007199254740992E15
        || this.triggeringCharacterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value (" + this.triggeringCharacterId + ") on element triggeringCharacterId.");
    }
    param1.writeDouble(this.triggeringCharacterId);
    if (this.triggeredSpellId < 0) {
      throw new Error(
          "Forbidden value (" + this.triggeredSpellId + ") on element triggeredSpellId.");
    }
    param1.writeVarShort(this.triggeredSpellId);
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
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

    this.markId = param1.readShort();

    this.triggeringCharacterId = param1.readDouble();
    if (this.triggeringCharacterId < -9.007199254740992E15
        || this.triggeringCharacterId > 9.007199254740992E15) {
      throw new Error(
          "Forbidden value ("
              + this.triggeringCharacterId
              + ") on element of GameActionFightTriggerGlyphTrapMessage.triggeringCharacterId.");
    }

    this.triggeredSpellId = param1.readVarUhShort();
    if (this.triggeredSpellId < 0) {
      throw new Error(
          "Forbidden value ("
              + this.triggeredSpellId
              + ") on element of GameActionFightTriggerGlyphTrapMessage.triggeredSpellId.");
    }
  }
}
