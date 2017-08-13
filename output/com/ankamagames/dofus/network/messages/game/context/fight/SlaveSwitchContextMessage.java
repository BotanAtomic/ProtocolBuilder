package com.ankamagames.dofus.network.messages.game.context.fight;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.data.items.SpellItem;
import com.ankamagames.dofus.network.types.game.character.characteristic.CharacterCharacteristicsInformations;
import com.ankamagames.dofus.network.types.game.shortcut.Shortcut;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;

public class SlaveSwitchContextMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6214;
    private boolean _isInitialized = false;
    private Number masterId = 0;
    private Number slaveId = 0;
    private SpellItem[] slaveSpells;
    private CharacterCharacteristicsInformations slaveStats;
    private Shortcut[] shortcuts;
    private FuncTree _slaveSpellstree;
    private FuncTree _slaveStatstree;
    private FuncTree _shortcutstree;


    public void serialize(ICustomDataOutput param1) {
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element masterId.");
         }
         param1.writeDouble(this.masterId);
         if(this.slaveId < -9.007199254740992E15 || this.slaveId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.slaveId + ") on element slaveId.");
         }
         param1.writeDouble(this.slaveId);
         param1.writeShort(this.slaveSpells.length);
         int _loc2_ = 0;
         while(_loc2_ < this.slaveSpells.length)
         {
            (this.slaveSpells[_loc2_] as SpellItem).serializeAs_SpellItem(param1);
            _loc2_++;
         }
         this.slaveStats.serializeAs_CharacterCharacteristicsInformations(param1);
         param1.writeShort(this.shortcuts.length);
         int _loc3_ = 0;
         while(_loc3_ < this.shortcuts.length)
         {
            param1.writeShort((this.shortcuts[_loc3_] as Shortcut).getTypeId());
            (this.shortcuts[_loc3_] as Shortcut).serialize(param1);
            _loc3_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         SpellItem _loc6_ = null;
         int _loc7_ = 0;
         Shortcut _loc8_ = null;
         this.masterId = param1.readDouble();
         if(this.masterId < -9.007199254740992E15 || this.masterId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.masterId + ") on element of SlaveSwitchContextMessage.masterId.");
         }
         this.slaveId = param1.readDouble();
         if(this.slaveId < -9.007199254740992E15 || this.slaveId > 9.007199254740992E15)
         {
            throw new Exception("Forbidden value (" + this.slaveId + ") on element of SlaveSwitchContextMessage.slaveId.");
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc6_ = new SpellItem();
            _loc6_.deserialize(param1);
            this.slaveSpells.push(_loc6_);
            _loc3_++;
         }
         this.slaveStats = new CharacterCharacteristicsInformations();
         this.slaveStats.deserialize(param1);
         int _loc4_ = param1.readUnsignedShort();
         int _loc5_ = 0;
         while(_loc5_ < _loc4_)
         {
            _loc7_ = param1.readUnsignedShort();
            _loc8_ = ProtocolTypeManager.getInstance(Shortcut,_loc7_);
            _loc8_.deserialize(param1);
            this.shortcuts.push(_loc8_);
            _loc5_++;
         }
    }

}