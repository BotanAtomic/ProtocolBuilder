package com.ankamagames.dofus.network.messages.game.guild;

import com.ankamagames.jerakine.network.NetworkMessage;
import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.social.GuildFactSheetInformations;
import com.ankamagames.dofus.network.types.game.character.CharacterMinimalInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;
import com.ankamagames.dofus.network.ProtocolTypeManager;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;
import java.lang.Exception;

public class GuildFactsMessage extends NetworkMessage implements INetworkMessage {

    private int protocolId = 6415;
    private boolean _isInitialized = false;
    private GuildFactSheetInformations infos;
    private int creationDate = 0;
    private int nbTaxCollectors = 0;
    private Vector<CharacterMinimalInformations> members;
    private FuncTree _infostree;
    private FuncTree _memberstree;


    public boolean isInitialized() {
         return this._isInitialized;
    }

    public int getMessageId() {
         return 6415;
    }

    public GuildFactsMessage initGuildFactsMessage(GuildFactSheetInformations param1,int  param2,int  param3,Vector<CharacterMinimalInformations>  param4) {
         this.infos = param1;
         this.creationDate = param2;
         this.nbTaxCollectors = param3;
         this.members = param4;
         this._isInitialized = true;
         return this;
    }

    public void reset() {
         this.infos = new GuildFactSheetInformations();
         this.nbTaxCollectors = 0;
         this.members = new Vector.<CharacterMinimalInformations>();
         this._isInitialized = false;
    }

    public void pack(ICustomDataOutput param1) {
         ByteArray _loc2_ = new ByteArray();
         this.serialize(new CustomDataWrapper(_loc2_));
         writePacket(param1,this.getMessageId(),_loc2_);
    }

    public void unpack(ICustomDataInput param1,int  param2) {
         this.deserialize(param1);
    }

    public FuncTree unpackAsync(ICustomDataInput param1,int  param2) {
         FuncTree _loc3_ = new FuncTree();
         _loc3_.setRoot(param1);
         this.deserializeAsync(_loc3_);
         return _loc3_;
    }

    public void serialize(ICustomDataOutput param1) {
         this.serializeAs_GuildFactsMessage(param1);
    }

    public void serializeAs_GuildFactsMessage(ICustomDataOutput param1) {
         param1.writeShort(this.infos.getTypeId());
         this.infos.serialize(param1);
         if(this.creationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.creationDate + ") on element creationDate.");
         }
         param1.writeInt(this.creationDate);
         if(this.nbTaxCollectors < 0)
         {
            throw new Exception("Forbidden value (" + this.nbTaxCollectors + ") on element nbTaxCollectors.");
         }
         param1.writeVarShort(this.nbTaxCollectors);
         param1.writeShort(this.members.length);
         int _loc2_ = 0;
         while(_loc2_ < this.members.length)
         {
            (this.members[_loc2_] as CharacterMinimalInformations).serializeAs_CharacterMinimalInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         this.deserializeAs_GuildFactsMessage(param1);
    }

    public void deserializeAs_GuildFactsMessage(ICustomDataInput param1) {
         CharacterMinimalInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         this.infos = ProtocolTypeManager.getInstance(GuildFactSheetInformations,_loc2_);
         this.infos.deserialize(param1);
         this._creationDateFunc(param1);
         this._nbTaxCollectorsFunc(param1);
         int _loc3_ = param1.readUnsignedShort();
         int _loc4_ = 0;
         while(_loc4_ < _loc3_)
         {
            _loc5_ = new CharacterMinimalInformations();
            _loc5_.deserialize(param1);
            this.members.push(_loc5_);
            _loc4_++;
         }
    }

    public void deserializeAsync(FuncTree param1) {
         this.deserializeAsyncAs_GuildFactsMessage(param1);
    }

    public void deserializeAsyncAs_GuildFactsMessage(FuncTree param1) {
         this._infostree = param1.addChild(this._infostreeFunc);
         param1.addChild(this._creationDateFunc);
         param1.addChild(this._nbTaxCollectorsFunc);
         this._memberstree = param1.addChild(this._memberstreeFunc);
    }

    private void _infostreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         this.infos = ProtocolTypeManager.getInstance(GuildFactSheetInformations,_loc2_);
         this.infos.deserializeAsync(this._infostree);
    }

    private void _creationDateFunc(ICustomDataInput param1) {
         this.creationDate = param1.readInt();
         if(this.creationDate < 0)
         {
            throw new Exception("Forbidden value (" + this.creationDate + ") on element of GuildFactsMessage.creationDate.");
         }
    }

    private void _nbTaxCollectorsFunc(ICustomDataInput param1) {
         this.nbTaxCollectors = param1.readVarUhShort();
         if(this.nbTaxCollectors < 0)
         {
            throw new Exception("Forbidden value (" + this.nbTaxCollectors + ") on element of GuildFactsMessage.nbTaxCollectors.");
         }
    }

    private void _memberstreeFunc(ICustomDataInput param1) {
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            this._memberstree.addChild(this._membersFunc);
            _loc3_++;
         }
    }

    private void _membersFunc(ICustomDataInput param1) {
         CharacterMinimalInformations _loc2_ = new CharacterMinimalInformations();
         _loc2_.deserialize(param1);
         this.members.push(_loc2_);
    }

}