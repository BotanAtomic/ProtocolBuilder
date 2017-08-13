package com.ankamagames.dofus.network.messages.game.character.choice;

import com.ankamagames.jerakine.network.INetworkMessage;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterToRemodelInformations;
import com.ankamagames.dofus.network.types.game.character.choice.CharacterBaseInformations;
import com.ankamagames.jerakine.network.ICustomDataOutput;
import com.ankamagames.jerakine.network.CustomDataWrapper;
import com.ankamagames.jerakine.network.ICustomDataInput;
import com.ankamagames.jerakine.network.utils.FuncTree;

public class CharactersListWithRemodelingMessage extends CharactersListMessage implements INetworkMessage {

    private int protocolId = 6550;
    private boolean _isInitialized = false;
    private CharacterToRemodelInformations[] charactersToRemodel;
    private FuncTree _charactersToRemodeltree;


    public void serialize(ICustomDataOutput param1) {
         super.serializeAs_CharactersListMessage(param1);
         param1.writeShort(this.charactersToRemodel.length);
         int _loc2_ = 0;
         while(_loc2_ < this.charactersToRemodel.length)
         {
            (this.charactersToRemodel[_loc2_] as CharacterToRemodelInformations).serializeAs_CharacterToRemodelInformations(param1);
            _loc2_++;
         }
    }

    public void deserialize(ICustomDataInput param1) {
         CharacterToRemodelInformations _loc4_ = null;
         int _loc4_ = 0;
         CharacterBaseInformations _loc5_ = null;
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = param1.readUnsignedShort();
            _loc5_ = ProtocolTypeManager.getInstance(CharacterBaseInformations,_loc4_);
            _loc5_.deserialize(param1);
            this.characters.push(_loc5_);
            _loc3_++;
         }
         int _loc2_ = param1.readUnsignedShort();
         int _loc3_ = 0;
         while(_loc3_ < _loc2_)
         {
            _loc4_ = new CharacterToRemodelInformations();
            _loc4_.deserialize(param1);
            this.charactersToRemodel.push(_loc4_);
            _loc3_++;
         }
    }

}