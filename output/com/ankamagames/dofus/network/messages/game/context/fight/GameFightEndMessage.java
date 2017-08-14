package com.ankamagames.dofus.network.messages.game.context.fight;

import java.lang.Exception;
import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.context.fight.FightResultListEntry;
import com.ankamagames.dofus.network.types.game.context.roleplay.party.NamedPartyTeamWithOutcome;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import flash.utils.ByteArray;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;

public class GameFightEndMessage extends NetworkMessage implements INetworkMessage {

  private boolean _isInitialized = false;
  public int duration = 0;
  public int ageBonus = 0;
  public int lootShareLimitMalus = 0;
  public Vector<FightResultListEntry> results;
  public Vector<NamedPartyTeamWithOutcome> namedPartyTeamsOutcomes;
  private FuncTree _resultstree;
  private FuncTree _namedPartyTeamsOutcomestree;
  public static final int protocolId = 720;

  public void serialize(ICustomDataOutput param1) {
    if (this.duration < 0) {
      throw new Error("Forbidden value (" + this.duration + ") on element duration.");
    }
    param1.writeInt(this.duration);
    param1.writeShort(this.ageBonus);
    param1.writeShort(this.lootShareLimitMalus);
    param1.writeShort(this.results.length);
    int _loc2_ = 0;
    while (_loc2_ < this.results.length) {
      param1.writeShort(((FightResultListEntry) (this.results[_loc2_])).getTypeId());
      ((FightResultListEntry) this.results[_loc2_]).serialize(param1);
      _loc2_++;
    }
    param1.writeShort(this.namedPartyTeamsOutcomes.length);
    int _loc3_ = 0;
    while (_loc3_ < this.namedPartyTeamsOutcomes.length) {
      ((NamedPartyTeamWithOutcome) this.namedPartyTeamsOutcomes[_loc3_]).serializeAs_(param1);
      _loc3_++;
    }
  }

  public void deserialize(ICustomDataInput param1) {
    int _loc6_ = 0;
    FightResultListEntry _loc7_ = null;
    NamedPartyTeamWithOutcome _loc8_ = null;
    this.duration = param1.readVarUhShort();
    if (this.duration < 0) {
      throw new Error(
          "Forbidden value (" + this.duration + ") on element of InteractiveUsedMessage.duration.");
    }

    this.ageBonus = param1.readShort();
    if (this.ageBonus < -1 || this.ageBonus > 1000) {
      throw new Error(
          "Forbidden value ("
              + this.ageBonus
              + ") on element of InteractiveElementWithAgeBonus.ageBonus.");
    }

    this.lootShareLimitMalus = param1.readShort();

    int _loc2_ = param1.readUnsignedShort();
    int _loc3_ = 0;
    while (_loc3_ < _loc2_) {
      _loc6_ = param1.readUnsignedShort();
      _loc7_ = ProtocolTypeManager.getInstance(FightResultListEntry, _loc6_);
      _loc7_.deserialize(param1);
      this.results.push(_loc7_);
      _loc3_++;
    }
    int _loc4_ = param1.readUnsignedShort();
    int _loc5_ = 0;
    while (_loc5_ < _loc4_) {
      _loc8_ = new NamedPartyTeamWithOutcome();
      _loc8_.deserialize(param1);
      this.namedPartyTeamsOutcomes.push(_loc8_);
      _loc5_++;
    }
  }
}
