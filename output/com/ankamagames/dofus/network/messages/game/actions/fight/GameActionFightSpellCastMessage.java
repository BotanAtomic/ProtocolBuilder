package com.ankamagames.dofus.network.messages.game.actions.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class GameActionFightSpellCastMessage extends AbstractGameActionFightTargetedAbilityMessage
    implements INetworkMessage {

  private boolean _isInitialized = false;
  public int spellId = 0;
  public int spellLevel = 0;
  public Vector<Integer> portalsIds;
  private FuncTree _portalsIdstree;
  public static final int protocolId = 1010;

  @Override
  public void serialize(ICustomDataOutput param1) {
    if (this.actionId < 0) {
      throw new Exception("Forbidden value (" + this.actionId + ") on element actionId.");
    }
    param1.writeVarShort(this.actionId);
    if (this.sourceId < -9.007199254740992E15 || this.sourceId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.sourceId + ") on element sourceId.");
    }
    param1.writeDouble(this.sourceId);

    int _loc2_ = 0;
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 0, this.silentCast);
    _loc2_ = BooleanByteWrapper.setFlag(_loc2_, 1, this.verboseCast);
    param1.writeByte(_loc2_);
    if (this.targetId < -9.007199254740992E15 || this.targetId > 9.007199254740992E15) {
      throw new Exception("Forbidden value (" + this.targetId + ") on element targetId.");
    }
    param1.writeDouble(this.targetId);
    if (this.destinationCellId < -1 || this.destinationCellId > 559) {
      throw new Exception(
          "Forbidden value (" + this.destinationCellId + ") on element destinationCellId.");
    }
    param1.writeShort(this.destinationCellId);
    param1.writeByte(this.critical);

    if (this.spellId < 0) {
      throw new Exception("Forbidden value (" + this.spellId + ") on element spellId.");
    }
    param1.writeVarShort(this.spellId);
    if (this.spellLevel < 1 || this.spellLevel > 200) {
      throw new Exception("Forbidden value (" + this.spellLevel + ") on element spellLevel.");
    }
    param1.writeShort(this.spellLevel);
    param1.writeShort(this.portalsIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.portalsIds.length) {
      param1.writeShort(this.portalsIds[_loc2_]);
      _loc2_++;
    }
  }

  @Override
  public void deserialize(ICustomDataInput param1) {
    Object _loc4_ = 0;
    this.uid = param1.readUTF();

    this.figure = param1.readVarUhShort();
    if (this.figure < 0) {
      throw new Exception(
          "Forbidden value (" + this.figure + ") on element of KrosmasterFigure.figure.");
    }

    this.pedestal = param1.readVarUhShort();
    if (this.pedestal < 0) {
      throw new Exception(
          "Forbidden value (" + this.pedestal + ") on element of KrosmasterFigure.pedestal.");
    }

    this.bound = param1.readBoolean();

    this.spellId = param1.readVarUhShort();
    if (this.spellId < 0) {
      throw new Exception(
          "Forbidden value (" + this.spellId + ") on element of ShortcutSpell.spellId.");
    }

    this.spellLevel = param1.readShort();
    if (this.spellLevel < 1 || this.spellLevel > 200) {
      throw new Exception(
          "Forbidden value (" + this.spellLevel + ") on element of SpellItem.spellLevel.");
    }

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc4_ = param1.readShort();
      this.portalsIds.push(_loc4_);
      _loc3_++;
    }
  }
}
