package com.ankamagames.dofus.network.messages.game.idol;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.idol.PartyIdol;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class IdolListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> chosenIdols;
  public Vector<uint> partyChosenIdols;
  public Vector<PartyIdol> partyIdols;
  private FuncTree _chosenIdolstree;
  private FuncTree _partyChosenIdolstree;
  private FuncTree _partyIdolstree;
  public static final int protocolId = 6585;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.chosenIdols.length);
    int _loc2_ = 0;
    while (_loc2_ < this.chosenIdols.length) {
      if (this.chosenIdols[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.chosenIdols[_loc2_]
                + ") on element 1 (starting at 1) of chosenIdols.");
      }
      param1.writeVarShort(this.chosenIdols[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.partyChosenIdols.length);
    int _loc3_ = 0;
    while (_loc3_ < this.partyChosenIdols.length) {
      if (this.partyChosenIdols[_loc3_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.partyChosenIdols[_loc3_]
                + ") on element 2 (starting at 1) of partyChosenIdols.");
      }
      param1.writeVarShort(this.partyChosenIdols[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.partyIdols.length);
    int _loc4_ = 0;
    while (_loc4_ < this.partyIdols.length) {
      param1.writeShort(((PartyIdol) (this.partyIdols[_loc4_])).getTypeId());
      ((PartyIdol) this.partyIdols[_loc4_]).serialize(param1);
      _loc4_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc8_ = 0;
    int _loc9_ = 0;
    int _loc10_ = 0;
    PartyIdol _loc11_ = null;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc8_ = param1.readVarUhShort();
      if (_loc8_ < 0) {
        throw new Exception("Forbidden value (" + _loc8_ + ") on elements of chosenIdols.");
      }
      this.chosenIdols.push(_loc8_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc9_ = param1.readVarUhShort();
      if (_loc9_ < 0) {
        throw new Exception("Forbidden value (" + _loc9_ + ") on elements of partyChosenIdols.");
      }
      this.partyChosenIdols.push(_loc9_);
      _loc5_++;
    }
    int _loc6_ = param1.readUnsignedShort();
    int _loc7_ = 0;
    while (_loc7_ < _loc6_) {
      _loc10_ = param1.readUnsignedShort();
      _loc11_ = ProtocolTypeManager.getInstance(PartyIdol, _loc10_);
      _loc11_.deserialize(param1);
      this.partyIdols.push(_loc11_);
      _loc7_++;
    }
  }
}
