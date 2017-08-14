package com.ankamagames.dofus.network.messages.game.context.roleplay.quest;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.roleplay.quest.QuestActiveInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class QuestListMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public Vector<uint> finishedQuestsIds;
  public Vector<uint> finishedQuestsCounts;
  public Vector<QuestActiveInformations> activeQuests;
  public Vector<uint> reinitDoneQuestsIds;
  private FuncTree _finishedQuestsIdstree;
  private FuncTree _finishedQuestsCountstree;
  private FuncTree _activeQueststree;
  private FuncTree _reinitDoneQuestsIdstree;
  public static final int protocolId = 5626;

  public void serialize(ICustomDataOutput param1) {
    param1.writeShort(this.finishedQuestsIds.length);
    int _loc2_ = 0;
    while (_loc2_ < this.finishedQuestsIds.length) {
      if (this.finishedQuestsIds[_loc2_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.finishedQuestsIds[_loc2_]
                + ") on element 1 (starting at 1) of finishedQuestsIds.");
      }
      param1.writeVarShort(this.finishedQuestsIds[_loc2_]);
      _loc2_++;
    }
    param1.writeShort(this.finishedQuestsCounts.length);
    int _loc3_ = 0;
    while (_loc3_ < this.finishedQuestsCounts.length) {
      if (this.finishedQuestsCounts[_loc3_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.finishedQuestsCounts[_loc3_]
                + ") on element 2 (starting at 1) of finishedQuestsCounts.");
      }
      param1.writeVarShort(this.finishedQuestsCounts[_loc3_]);
      _loc3_++;
    }
    param1.writeShort(this.activeQuests.length);
    int _loc4_ = 0;
    while (_loc4_ < this.activeQuests.length) {
      param1.writeShort(((QuestActiveInformations) (this.activeQuests[_loc4_])).getTypeId());
      ((QuestActiveInformations) this.activeQuests[_loc4_]).serialize(param1);
      _loc4_++;
    }
    param1.writeShort(this.reinitDoneQuestsIds.length);
    int _loc5_ = 0;
    while (_loc5_ < this.reinitDoneQuestsIds.length) {
      if (this.reinitDoneQuestsIds[_loc5_] < 0) {
        throw new Exception(
            "Forbidden value ("
                + this.reinitDoneQuestsIds[_loc5_]
                + ") on element 4 (starting at 1) of reinitDoneQuestsIds.");
      }
      param1.writeVarShort(this.reinitDoneQuestsIds[_loc5_]);
      _loc5_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc10_ = 0;
    int _loc11_ = 0;
    int _loc12_ = 0;
    QuestActiveInformations _loc13_ = null;
    int _loc14_ = 0;
    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc10_ = param1.readVarUhShort();
      if (_loc10_ < 0) {
        throw new Exception("Forbidden value (" + _loc10_ + ") on elements of finishedQuestsIds.");
      }
      this.finishedQuestsIds.push(_loc10_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc11_ = param1.readVarUhShort();
      if (_loc11_ < 0) {
        throw new Exception(
            "Forbidden value (" + _loc11_ + ") on elements of finishedQuestsCounts.");
      }
      this.finishedQuestsCounts.push(_loc11_);
      _loc5_++;
    }
    int _loc6_ = param1.readUnsignedShort();
    int _loc7_ = 0;
    while (_loc7_ < _loc6_) {
      _loc12_ = param1.readUnsignedShort();
      _loc13_ = ProtocolTypeManager.getInstance(QuestActiveInformations, _loc12_);
      _loc13_.deserialize(param1);
      this.activeQuests.push(_loc13_);
      _loc7_++;
    }
    int _loc8_ = param1.readUnsignedShort();
    int _loc9_ = 0;
    while (_loc9_ < _loc8_) {
      _loc14_ = param1.readVarUhShort();
      if (_loc14_ < 0) {
        throw new Exception(
            "Forbidden value (" + _loc14_ + ") on elements of reinitDoneQuestsIds.");
      }
      this.reinitDoneQuestsIds.push(_loc14_);
      _loc9_++;
    }
  }
}
